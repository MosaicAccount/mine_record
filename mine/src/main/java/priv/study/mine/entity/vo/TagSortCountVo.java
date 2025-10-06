package priv.study.mine.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author JLian
 * @date 2025年10月04日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagSortCountVo {

    /**
     * 分类名称
     */
    private String sortName;

    private Long count;

}
