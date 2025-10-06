package priv.study.mine.entity.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 笔记保存参数
 *
 * @author JLian
* @date 2025年10月04日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotesSaveDto {

    @NotEmpty(message = "标题不能为空")
    private String title;

    @NotEmpty(message = "笔记类型不能为空")
    private String notesType;


    private String desc;

    private String content;

    @NotEmpty(message = "标签不能为空")
    private List<Long> tagList;

    private String attachments;

}
