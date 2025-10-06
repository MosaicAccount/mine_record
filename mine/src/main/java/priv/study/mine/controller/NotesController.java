package priv.study.mine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotEmpty;
import lombok.extern.slf4j.Slf4j;
import priv.study.mine.entity.dto.NotesListQueryDto;
import priv.study.mine.entity.dto.NotesSaveDto;
import priv.study.mine.entity.vo.NotesInfoVo;
import priv.study.mine.entity.vo.NotesListVo;
import priv.study.mine.entity.vo.TimeDimensionCountVo;
import priv.study.mine.service.NotesService;

/**
 * 笔记相关接口
 *
 * @author JLian
* @date 2025年10月04日
 */
@RestController
@RequestMapping("/notes/")
@Slf4j
public class NotesController {

    @Autowired
    private NotesService notesService;


    @PostMapping("list")
    public List<NotesListVo> getNotesList(@RequestBody NotesListQueryDto query) {
        return notesService.getNotesList(query);
    }

    @PostMapping("save")
    public void saveNotes(@RequestBody NotesSaveDto saveDto) {
        notesService.saveNotes(saveDto);
    }

    @GetMapping("delete/{notesId}")
    public void deleteNotes(@PathVariable Long notesId) {
        notesService.deleteNotes(notesId);
    }


    @GetMapping("get/{notesId}")
    public NotesInfoVo getNotes(@PathVariable Long notesId) {
        return notesService.getNotes(notesId);
    }

    @GetMapping("timeDimension/{timeDimension}")
    public List<TimeDimensionCountVo>  getNotesTimeDimension(@NotEmpty(message = "时间维度不能为空") @PathVariable String timeDimension) {
        return notesService.getNotesTimeDimension(timeDimension);
    }

}
