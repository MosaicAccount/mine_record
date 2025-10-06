package priv.study.mine.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import priv.study.mine.entity.ModuleTag;

/**
 *  模块标签数据库操作层
 * 
 * @author JLian
 * @date 2025年10月04日
 */
@Repository
public interface ModuleTagRepository extends JpaRepository<ModuleTag, Long> {

    List<ModuleTag> findByModuleId(Long moduleId);

    List<ModuleTag> findByModuleIdIn(List<Long> moduleIdList);

    List<ModuleTag> findByTagId(Long tagId);


    List<ModuleTag> findByTagIdIn(List<Long> TagIdList);
    
}
