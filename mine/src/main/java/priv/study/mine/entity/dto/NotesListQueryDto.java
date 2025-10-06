package priv.study.mine.entity.dto;

import lombok.*;
import priv.study.mine.common.entity.PageDto;

/**
 * 笔记列表查询参数
 *
 * @author JLian
* @date 2025年10月04日
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotesListQueryDto extends PageDto {

    /**
     * 笔记类型（1-笔记，2-便签）
     */
    private String notesType;

    /**
     * 标签 ID
     */
    private String tagId;

}
