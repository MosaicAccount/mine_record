package priv.study.mine.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

/**
 * 笔记标签
 *
 * @author JLian
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_tags")
@Comment("标签")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tag_name", length = 128, unique = true, nullable = false)
    @Comment("标签名称")
    private String tagName;

    @Column(name = "tag_id", unique = true, nullable = false)
    @Comment("标签ID")
    private Long tagId;

    @Column(name = "tag_type", nullable = false, columnDefinition = "CHAR(1) CHECK(tag_type IN ('1', '2', '3', '4'))")
    @Comment("标签类型（1-电影标签，2-旅行标签，3-书籍标签，4-笔记标签）")
    private String tagType;

    @Column(name = "create_time", nullable = false)
    @Comment("创建时间")
    private LocalDateTime createTime;
}
