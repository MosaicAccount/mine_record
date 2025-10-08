package priv.study.mine.oss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import priv.study.mine.oss.model.FileUploadRequest;
import priv.study.mine.oss.service.FileService;

/**
 * 文件相关接口
 * 
 * @author JLian
 * @date 2025年10月07日
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;
     
    @PostMapping("/upload")
    public String upload(@ModelAttribute FileUploadRequest uploadRequest) {
        return fileService.upload(uploadRequest);
    }

    @RequestMapping("/download/{fileKey}")
    public void download(@PathVariable("fileKey") String fileKey, HttpServletResponse response) {
        fileService.download(fileKey, response);
    }
    
}
