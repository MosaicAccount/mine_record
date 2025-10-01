package priv.study.mine.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 书籍信息
 *
 * @author JLian
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_book")
@Comment("书籍信息")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_name", length = 128, nullable = false)
    @Comment("书籍名称")
    private String bookName;

    @Column(name = "author", length = 128)
    @Comment("作者")
    private String author;

    @Column(name = "status", nullable = false, columnDefinition = "CHAR(1) CHECK(status IN ('1', '2', '3'))")
    @Comment("书籍状态（1-在读，2-已读，3-想读）")
    private String status;

    @Column(name = "rating", scale = 1)
    @Comment("书籍评分")
    private Double rating;

    @Column(name = "cover_image", length = 512)
    @Comment("封面图片")
    private String cover_image;

    @Column(name = "recommend", scale = 1)
    @Comment("推荐度")
    private Double recommend;

    @Column(name = "start_date")
    @Comment("开始时间")
    private LocalDate startDate;

    @Column(name = "end_date")
    @Comment("结束时间")
    private LocalDate endDate;

    @Column(name = "watch_times")
    @Comment("观看次数")
    private Integer watchTimes;

    @Column(name = "notes_id")
    @Comment("笔记ID")
    private Long notesId;

    @Column(name = "create_time", nullable = false, updatable = false)
    @Comment("创建时间")
    private LocalDateTime createTime;

    @Column(name = "update_time", nullable = false)
    @Comment("更新时间")
    private LocalDateTime updateTime;
}
