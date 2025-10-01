package priv.study.mine.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * @author JLian
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_notes_tags")
@Comment("笔记标签关联表")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotesTags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "notes_id")
    @Comment("笔记ID")
    private Long notesId;

    @Column(name = "tag_id")
    @Comment("标签ID")
    private Long tagId;


}
