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
 * 影视信息
 *
 * @author JLian
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_audio_visual")
@Comment("影视信息")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AudioVisual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "avName", length = 128, nullable = false)
    @Comment("影视名称")
    private String avName;

    @Column(name = "director", length = 128)
    @Comment("导演")
    private String director;

    @Column(name = "release_date")
    @Comment("上映日期")
    private LocalDate release_date;

    @Column(name = "type", columnDefinition = "CHAR(1) CHECK(type IN ('1', '2'))")
    @Comment("电影类型（1-电影，2-电视剧）")
    private String type;

    @Column(name = "status", columnDefinition = "CHAR(1) CHECK(status IN ('1', '2', '3'))")
    @Comment("影视状态（1-在看，2-已看，3-想看）")
    private String status;

    @Column(name = "rating", scale = 1)
    @Comment("评分")
    private Double rating;

    @Column(name = "watch_times")
    @Comment("观看次数")
    private Integer watch_times;

    @Column(name = "notes_id")
    @Comment("笔记ID")
    private Long notesId;

    @Column(name = "cover_image", length = 512)
    private String cover_image;

    @Column(name = "create_time", nullable = false, updatable = false)
    @Comment("创建时间")
    private LocalDateTime createTime;

    @Column(name = "update_time", nullable = false)
    @Comment("更新时间")
    private LocalDateTime updateTime;

}
