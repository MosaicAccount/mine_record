package priv.study.mine.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import priv.study.mine.common.enumerate.ModuleEnum;
import priv.study.mine.common.exception.BusinessException;
import priv.study.mine.common.exception.ErrorEnum;
import priv.study.mine.convert.TagConverter;
import priv.study.mine.dao.ModuleTagRepository;
import priv.study.mine.dao.TagRepository;
import priv.study.mine.entity.ModuleTag;
import priv.study.mine.entity.Tag;
import priv.study.mine.entity.dto.TagSaveDto;
import priv.study.mine.entity.vo.TagSortCountVo;
import priv.study.mine.entity.vo.TagVo;

/**
 * 标签业务层
 * 
 * @author JLian
 * @date 2025年10月04日
 */
@Service
@Slf4j
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private ModuleTagRepository moduleTagRepository;

    @Autowired
    private TagConverter converter;

    public TagVo getTagById(Long id) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ModuleEnum.TAG, ErrorEnum.DATA_NOT_EXIST));
        return converter.convertTotagVo(tag);
    }

    public List<TagVo> getTagListByIdList(List<Long> ids) {
        List<Tag> tagList = tagRepository.findAllById(ids);
        return converter.convertTotagVo(tagList);
    }

    public List<TagVo> getTagListByTagType(String tagType) {
        List<Tag> tagList = null;
        if (StringUtils.isNotEmpty(tagType)) {
            tagList = tagRepository.findByTagType(tagType);
        } else {
            tagList = tagRepository.findAll();
        }
        return converter.convertTotagVo(tagList);
    }

    /**
     * 根据模块ID查询标签列表
     *
     * @param moduleId 模块ID
     * @return 标签列表
     */
    public List<TagVo> getTagByModuleId(Long moduleId) {
        // 查询模块关联的标签
        List<ModuleTag> moduleList = moduleTagRepository.findByModuleId(moduleId);
        if (CollectionUtils.isEmpty(moduleList)) {
            log.warn("模块ID：{}， 标签关联关系列表为空，没有关联的标签。", moduleId);
            throw new BusinessException(ModuleEnum.TAG, ErrorEnum.DATA_NOT_EXIST);
        }
        // 获取标签列表
        Set<Long> tagIdList = moduleList.stream().map(ModuleTag::getTagId).collect(Collectors.toSet());
        List<Tag> tagList = tagRepository.findAllById(tagIdList);
        if (CollectionUtils.isEmpty(tagList)) {
            log.warn("模块ID：{}，没有关联的标签。", moduleId);
        }
        return converter.convertTotagVo(tagList, moduleId);
    }

    /**
     * 根据模块ID列表查询标签列表
     *
     * @param moduleIdList 模块ID列表
     * @return 模块标签
     */
    public List<TagVo> getTagByModuleId(List<Long> moduleIdList) {
        // 查询模块关联的标签
        List<ModuleTag> moduleTagList = moduleTagRepository.findByModuleIdIn(moduleIdList);
        if (CollectionUtils.isEmpty(moduleTagList)) {
            log.warn("标签关联关系列表为空，没有关联的标签。");
            throw new BusinessException(ModuleEnum.TAG, ErrorEnum.DATA_NOT_EXIST);
        }
        // 获取标签列表
        Set<Long> tagIdList = moduleTagList.stream().map(ModuleTag::getTagId).collect(Collectors.toSet());
        List<Tag> tagList = tagRepository.findAllById(tagIdList);
        if (CollectionUtils.isEmpty(tagList)) {
            log.warn("没有关联的标签。");
            throw new BusinessException(ModuleEnum.TAG, ErrorEnum.DATA_NOT_EXIST);
        }
        Map<Long, Long> idMapping = moduleTagList.stream()
                .collect(Collectors.toMap(ModuleTag::getTagId, ModuleTag::getModuleId, (o1, o2) -> o2));
        return tagList.stream()
                .map(tag -> converter.convertTotagVo(tag, idMapping.get(tag.getId())))
                .collect(Collectors.toList());
    }

    /**
     * 保存标签
     *
     * @param tagSaveDto 标签保存信息
     */
    public void saveTag(TagSaveDto tagSaveDto) {
        try {
            tagRepository.save(converter.convertTotag(tagSaveDto));
            log.info("标签信息保存成功");
        } catch (Exception e) {
            log.error("标签信息保存失败", e);
            throw new BusinessException(ModuleEnum.TAG, "标签信息保存失败", e);
        }
    }

    /**
     * 根据标签类型分类统计
     * @param tagType
     * @return 分类统计结果列表
     */
    public List<TagSortCountVo> getTagSortCount(String tagType) {
        // 根据标签类型查询标签列表
        List<Tag> tagList = tagRepository.findByTagType(tagType);
        // 根据标签关系表统计
        List<Long> tagIdList = tagList.stream().map(Tag::getId).collect(Collectors.toList());
        Map<Long, String> tagNameMapping = tagList.stream()
                .collect(Collectors.toMap(Tag::getId, Tag::getTagName));
        List<ModuleTag> moduleTagList = moduleTagRepository.findByTagIdIn(tagIdList);
        return moduleTagList.stream()
                .collect(Collectors.groupingBy(ModuleTag::getTagId, Collectors.counting()))
                .entrySet()
                .stream()
                .map(entry -> TagSortCountVo.builder()
                        .sortName(tagNameMapping.get(entry.getKey()))
                        .count(entry.getValue())
                        .build())
                .collect(Collectors.toList());
    }
}
