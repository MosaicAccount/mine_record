package priv.study.mine.entity.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 笔记列表展示信息
 *
 * @author JLian
* @date 2025年10月04日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotesListVo {

    private Long id;

    private String notesName;

    private String notesType;

    private String desc;

    private String createDate;

    private List<TagVo> tagList;

}
