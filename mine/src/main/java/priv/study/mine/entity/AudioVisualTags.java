package priv.study.mine.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 影视标签关联表
 *
 * @author JLian
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_audio_visual_tags")
@Comment("影视标签关联表")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AudioVisualTags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "audio_visual_id")
    @Comment("影视ID")
    private Long audioVisualId;

    @Column(name = "tag_id")
    @Comment("标签ID")
    private Long tagId;
}
