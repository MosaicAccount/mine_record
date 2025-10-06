package priv.study.mine.entity;

import org.hibernate.annotations.Comment;

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
 * 笔记标签
 *
 * @author JLian
* @date 2025年10月04日
 */
@Entity
@Table(name = "tb_tag")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Tag extends BaseEntity {

    @Column(name = "tag_name")
    @Comment("标签名称")
    private String tagName;

    @Column(name = "tag_value", unique = true, nullable = false)
    @Comment("标签值")
    private Long tagValue;

    @Column(name = "tag_type", nullable = false, columnDefinition = "CHAR(1) CHECK(tag_type IN ('1', '2', '3', '4'))")
    @Comment("标签类型（1-电影标签，2-旅行标签，3-书籍标签，4-笔记标签）")
    private String tagType;
}
