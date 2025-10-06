package priv.study.mine.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import priv.study.mine.entity.Notes;
import priv.study.mine.entity.vo.TimeDimensionCountVo;

/**
 * 笔记数据库操作层
 *
 * @author JLian
 * @date 2025年10月04日
 */
@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {

    /**
     * 根据笔记类型查询笔记
     *
     * @param notesType 笔记类型
     * @param pageable  分页参数
     * @return 笔记列表
     */
    List<Notes> findByNotesTypeOrderByCreateTimeDesc(String notesType, Pageable pageable);

    /**
     * 获取年份统计
     *
     * @return 年份统计列表
     */ 
    @Query(value = "SELECT COUNT(id) AS count, TO_CHAR(create_time, 'YYYY') AS time"
            + " FROM tb_notes"
            + " GROUP BY TO_CHAR(create_time, 'YYYY')", nativeQuery = true)
    List<TimeDimensionCountVo> getYearCount();

    /**
     * 获取月份统计
     *
     * @return 月份统计列表
     */
    @Query(value = "SELECT COUNT(id) AS count, TO_CHAR(create_time, 'YYYY-MM') AS time"
            + " FROM tb_notes"
            + " GROUP BY TO_CHAR(create_time, 'YYYY-MM')", nativeQuery = true)
    List<TimeDimensionCountVo> getMonthCount();
}