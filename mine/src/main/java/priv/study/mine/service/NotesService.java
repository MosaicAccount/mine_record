package priv.study.mine.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import priv.study.mine.common.constants.NotesConstants;
import priv.study.mine.common.enumerate.ModuleEnum;
import priv.study.mine.common.enumerate.TimeDimensionEnum;
import priv.study.mine.common.exception.BusinessException;
import priv.study.mine.common.exception.ErrorEnum;
import priv.study.mine.convert.NotesConverter;
import priv.study.mine.dao.ModuleTagRepository;
import priv.study.mine.dao.NotesRepository;
import priv.study.mine.entity.ModuleTag;
import priv.study.mine.entity.Notes;
import priv.study.mine.entity.dto.NotesListQueryDto;
import priv.study.mine.entity.dto.NotesSaveDto;
import priv.study.mine.entity.vo.NotesInfoVo;
import priv.study.mine.entity.vo.NotesListVo;
import priv.study.mine.entity.vo.TagVo;
import priv.study.mine.entity.vo.TimeDimensionCountVo;

/**
 * 笔记业务层
 *
 * @author JLian
 * @date 2025年10月04日
 */
@Service
@Slf4j
public class NotesService {

    @Autowired
    private NotesRepository notesRepository;

    @Autowired
    private NotesConverter converter;

    @Autowired
    private TagService tagService;

    @Autowired
    private ModuleTagRepository moduleTagsRepository;

    public List<NotesListVo> getNotesList(NotesListQueryDto query) {
        Pageable pageable = PageRequest.of(query.getPageNum(), query.getPageSize());
        List<Notes> notesList = notesRepository.findByNotesTypeOrderByCreateTimeDesc(query.getNotesType(), pageable);
        if (CollectionUtils.isEmpty(notesList)) {
            log.warn("笔记列表为空");
            return null;
        }

        // 查询每个笔记关联的标签
        List<Long> notesIdList = notesList.stream().map(notes -> notes.getId()).collect(Collectors.toList());
        List<TagVo> tagList = tagService.getTagByModuleId(notesIdList);
        Map<Long, List<TagVo>> tagMap = tagList.stream().collect(Collectors.groupingBy(TagVo::getModuleId));
        return notesList.stream()
                .map(notes -> converter.convertToNotesListVo(notes, tagMap.get(notes.getId())))
                .collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveNotes(NotesSaveDto saveDto) {
        if (NotesConstants.STICKY_NOTES.equals(saveDto.getNotesType()) && StringUtils.isEmpty(saveDto.getContent())) {
            throw new BusinessException(ModuleEnum.NOTES, "笔记类型为便签，但是便签内容为空。");
        }
        try {
            // 保存笔记
            Notes notes = notesRepository.save(converter.convertToNotes(saveDto));
            log.info("保存笔记成功。笔记ID：{}", notes.getId());
            // 保存标签
            List<ModuleTag> moduleTagsList = saveDto.getTagList().stream()
                    .map(tagId -> ModuleTag.builder()
                            .moduleId(notes.getId())
                            .tagId(tagId)
                            .build())
                    .collect(Collectors.toList());
            moduleTagsRepository.saveAll(moduleTagsList);
            log.info("保存笔记标签成功。");
        } catch (Exception e) {
            throw new BusinessException(ModuleEnum.NOTES, ErrorEnum.SAVE_FAIL, e);
        }
    }

    @Transactional(rollbackFor = Exception.class, noRollbackFor = BusinessException.class)
    public void deleteNotes(Long notesId) {
        try {
            // 删除笔记
            notesRepository.deleteById(notesId);
            log.info("删除笔记成功。笔记ID：{}", notesId);
            // 删除笔记标签关系
            List<ModuleTag> moduleTagList = moduleTagsRepository.findByModuleId(notesId);
            moduleTagsRepository.deleteAllInBatch(moduleTagList);
            log.info("删除笔记标签关系成功。");
        } catch (Exception e) {
            throw new BusinessException(ModuleEnum.NOTES, ErrorEnum.DELETE_FAIL, e);
        }
    }

    public NotesInfoVo getNotes(Long notesId) {
        Notes notes = notesRepository.findById(notesId)
                .orElseThrow(() -> new BusinessException(ModuleEnum.NOTES, ErrorEnum.DATA_NOT_EXIST));
        List<TagVo> tagList = tagService.getTagByModuleId(notesId);
        return converter.convertToNotesInfoVo(notes, tagList);
    }

    public List<TimeDimensionCountVo> getNotesTimeDimension(String timeDimension) {
        if (TimeDimensionEnum.MONTH.getCode().equals(timeDimension)) {
            return notesRepository.getMonthCount();
        } else if (TimeDimensionEnum.YEAR.getCode().equals(timeDimension)) {
            return notesRepository.getYearCount();
        }
        return null;
    }
}