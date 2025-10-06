package priv.study.mine.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import priv.study.mine.entity.Tag;

/**
 * @author JLian
* @date 2025年10月04日
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> findByTagType(String tagType);
}
