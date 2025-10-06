package priv.study.mine.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author JLian
 * @date 2025年10月05日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagSaveDto {

    private Long tagValue;
    private String tagName;
    private String tagType;

}
