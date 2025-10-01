package priv.study.mine.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 笔记信息
 *
 * @author JLian
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_notes")
@Comment("笔记信息")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 128, nullable = false)
    @Comment("笔记标题")
    private String title;

    @Column(name = "notes_type", nullable = false, columnDefinition = "CHAR(1) CHECK(notes_type IN ('1', '2'))")
    @Comment("笔记类型（1-笔记，2-小记）")
    private String notesType;

    @Column(name = "description")
    @Comment("笔记描述")
    private String desc;

    @Column(name = "content", columnDefinition = "TEXT")
    @Comment("小记内容")
    private String content;

    @Column(name = "attachments")
    @Comment("附件")
    private String attachments;

    @Column(name = "create_time", nullable = false, updatable = false)
    @Comment("创建时间")
    private LocalDateTime createTime;

    @Column(name = "update_time", nullable = false)
    @Comment("更新时间")
    private LocalDateTime updateTime;



}
