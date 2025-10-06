package priv.study.mine.entity;

import java.io.Serial;

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
 * 笔记信息
 *
 * @author JLian
* @date 2025年10月04日
 */
@Entity
@Table(name = "tb_notes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Notes extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 7604175790793547990L;
    
    @Column(name = "title")
    private String title;

    @Column(name = "notes_type")
    private String notesType;

    @Column(name = "description")
    private String desc;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "attachments")
    private String attachments;

}
