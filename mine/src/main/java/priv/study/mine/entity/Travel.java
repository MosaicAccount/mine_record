package priv.study.mine.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import priv.study.mine.common.entity.BaseEntity;

import java.io.Serial;
import java.time.LocalDate;

/**
 * 旅行信息
 *
 * @author JLian
* @date 2025年10月04日
 */

@Entity
@Table(name = "tb_travel")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Travel extends BaseEntity {


    @Serial
    private static final long serialVersionUID = 5959400654409947781L;

    @Column(name = "country", length = 128, nullable = false)
    private String country;

    @Column(name = "city", length = 128, nullable = false)
    private String city;

    @Column(name = "longitude", scale = 8, nullable = false)
    private Double longitude;

    @Column(name = "latitude", scale = 8, nullable = false)
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


}
