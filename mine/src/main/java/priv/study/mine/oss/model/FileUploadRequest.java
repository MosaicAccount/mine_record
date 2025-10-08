package priv.study.mine.oss.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author JLian
 * @date 2025年10月07日
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileUploadRequest {
    
    /**
     * 文件名称
     */
    private String fileName;


    /**
     * 文件内容
     */
    private MultipartFile file;

    /**
     * 文件类型
     */
    private String fileType;

}
