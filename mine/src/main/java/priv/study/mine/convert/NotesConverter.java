package priv.study.mine.convert;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import priv.study.mine.entity.Notes;
import priv.study.mine.entity.dto.NotesSaveDto;
import priv.study.mine.entity.vo.NotesInfoVo;
import priv.study.mine.entity.vo.NotesListVo;
import priv.study.mine.entity.vo.TagVo;

/**
 * 笔记实体转换类
 *
 * @author JLian
* @date 2025年10月04日
 */
@Mapper(componentModel = "spring")
public interface NotesConverter {

    @Mapping(source = "notes.id", target = "id")
    @Mapping(source = "notes.title", target = "notesName")
    @Mapping(source = "notes.notesType", target = "notesType")
    @Mapping(source = "notes.desc", target = "desc")
    @Mapping(source = "notes.createTime", target = "createDate", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "tagList", target = "tagList")
    NotesListVo convertToNotesListVo(Notes notes, List<TagVo> tagList);



    @Mapping(source = "title", target = "title")
    @Mapping(source = "notesType", target = "notesType")
    @Mapping(source = "desc", target = "desc")
    Notes convertToNotes(NotesSaveDto saveDto);


    @Mapping(source = "notes.id", target = "id")
    @Mapping(source = "notes.title", target = "notesName")
    @Mapping(source = "notes.notesType", target = "notesType")
    @Mapping(source = "notes.desc", target = "desc")
    @Mapping(source = "notes.content", target = "content")
    @Mapping(source = "notes.attachments", target = "attachments")
    @Mapping(source = "notes.createTime", target = "createDate", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "tagList", target = "tagList")
    NotesInfoVo convertToNotesInfoVo(Notes notes, List<TagVo> tagList);
}
