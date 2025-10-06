package priv.study.mine.convert;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import priv.study.mine.entity.Tag;
import priv.study.mine.entity.dto.TagSaveDto;
import priv.study.mine.entity.vo.TagVo;

/**
 * 标签实体转换器
 * 
 * @author JLian
 * @date 2025年10月04日
 */
@Mapper(componentModel = "spring")
public interface TagConverter {


    @Mapping(source = "id", target = "id")
    @Mapping(source = "tagName", target = "tagName")
    @Mapping(target = "moduleId",ignore = true)
    TagVo convertTotagVo(Tag tag);

    @Mapping(source = "tag.id", target = "id")
    @Mapping(source = "tag.tagName", target = "tagName")
    @Mapping(source = "moduleId", target = "moduleId")
    TagVo convertTotagVo(Tag tag, Long moduleId);


    List<TagVo> convertTotagVo(List<Tag> tag);

    default List<TagVo> convertTotagVo(List<Tag> tagList, Long moduleId) {
        return tagList.stream()
                .map(tag -> convertTotagVo(tag, moduleId))
                .collect(Collectors.toList());
    }

    @Mapping(source = "tagValue", target = "tagValue")
    @Mapping(source = "tagName", target = "tagName")
    @Mapping(source = "tagType",target = "tagType")
    Tag convertTotag(TagSaveDto tagSaveDto);
    
}
