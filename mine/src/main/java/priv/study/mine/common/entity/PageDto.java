package priv.study.mine.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页信息
 *
 * @author JLian
* @date 2025年10月04日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageDto {

    private Integer pageNum = 1;

    private Integer pageSize = 10;

}
