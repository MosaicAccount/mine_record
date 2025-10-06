package priv.study.mine.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import priv.study.mine.common.entity.BaseEntity;

/**
 * 模块标签关联表
 * 
 * @author JLian
 * @date 2025年10月04日
 */
@Entity
@Table(name = "tb_module_tag")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ModuleTag extends BaseEntity {

    @Column(name = "module_id")
    private Long moduleId;

    @Column(name = "tag_id")
    private Long tagId;

}
