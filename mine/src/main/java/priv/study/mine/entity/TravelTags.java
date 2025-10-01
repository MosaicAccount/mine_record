package priv.study.mine.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

/**
 * 旅行标签关联表
 *
 * @author JLian
 * @version 0.0.1
 * @since 0.0.1
 */
@Entity
@Table(name = "tb_travel_tags")
@Comment("旅行标签关联表")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TravelTags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "travel_id")
    @Comment("旅行ID")
    private Long travelId;

    @Column(name = "tag_id")
    @Comment("标签ID")
    private Long tagId;



}
