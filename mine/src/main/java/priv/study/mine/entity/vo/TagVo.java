package priv.study.mine.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 标签信息展示
 * 
 * @author JLian
 * @date 2025年10月04日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagVo {

    private Long id;

    private String tagName;

    private Long moduleId;
    
}
