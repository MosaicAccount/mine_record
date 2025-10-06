package priv.study.mine.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 时间维度数据统计
 * 
 * @author JLian
 * @date 2025年10月05日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeDimensionCountVo {

    private Long count;

    private String time;
    
}
