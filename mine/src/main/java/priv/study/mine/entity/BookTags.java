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
@Table(name = "tb_book_notes")
@Comment("书籍标签关联表")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookTags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_id")
    @Comment("书籍ID")
    private Long bookId;

    @Column(name = "tag_id")
    @Comment("标签ID")
    private Long tagId;
}
