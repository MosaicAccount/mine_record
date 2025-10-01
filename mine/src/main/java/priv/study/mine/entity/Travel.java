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
 * 旅行信息
 *
 * @author JLian
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_travel")
@Comment("旅行信息")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country", length = 128, nullable = false)
    @Comment("国家")
    private String country;

    @Column(name = "city", length = 128, nullable = false)
    @Comment("城市")
    private String city;

    @Column(name = "longitude", scale = 8, nullable = false)
    @Comment("经度")
    private Double longitude;

    @Column(name = "latitude", scale = 8, nullable = false)
    @Comment("纬度")
    private Double latitude;

    @Column(name = "status", nullable = false, columnDefinition = "CHAR(1) CHECK(status IN ('1', '2'))")
    @Comment("旅行状态（1-想去，2-已去）")
    private String status;

    @Column(name = "recommend", scale = 1)
    @Comment("推荐度")
    private Double recommend;

    @Column(name = "departure_date")
    @Comment("出发日期")
    private LocalDate departureDate;

    @Column(name = "notes_id")
    private Long notesId;

    @Column(name = "create_time", nullable = false, updatable = false)
    @Comment("创建时间")
    private LocalDateTime createTime;

    @Column(name = "update_time", nullable = false)
    @Comment("更新时间")
    private LocalDateTime updateTime;
}
