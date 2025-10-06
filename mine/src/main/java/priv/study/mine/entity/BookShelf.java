package priv.study.mine.entity;

import java.time.LocalDate;

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
 * 书籍信息
 *
 * @author JLian
* @date 2025年10月04日
 */
@Entity
@Table(name = "tb_bookshelf")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BookShelf extends BaseEntity {

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "author")
    private String author;

    @Column(name = "status")
    private String status;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "cover_image")
    private String cover_image;

    @Column(name = "recommend", scale = 1)
    private Double recommend;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "watch_times")
    private Integer watchTimes;

    @Column(name = "notes_id")
    private Long notesId;

}
