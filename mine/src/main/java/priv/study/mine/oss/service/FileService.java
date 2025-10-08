package priv.study.mine.oss.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import priv.study.mine.oss.StorageType;
import priv.study.mine.oss.exception.FileStorageException;
import priv.study.mine.oss.factory.FileStorageFactory;
import priv.study.mine.oss.model.FileUploadRequest;
import priv.study.mine.oss.strategy.FileStorage;

/**
 * @author JLian
 * @date 2025年10月07日
 */
@Service
@Slf4j
public class FileService {

    private final FileStorageFactory factory;

    @Value("${file.storage.default-type:LOCAL}")
    private StorageType storageType;

    public FileService(FileStorageFactory factory) {
        this.factory = factory;
    }

    public String upload(FileUploadRequest uploadRequest) {
        FileStorage fileStorage = factory.getStorageType(storageType);
        try {
            return fileStorage.upload(uploadRequest);
        } catch (FileStorageException e) {
            throw new FileStorageException("上传失败", e);
        } catch (Exception e) {
            throw new FileStorageException("上传失败", e);
        }
    }

    public void download(String fileKey, HttpServletResponse response) {
        FileStorage fileStorage = factory.getStorageType(storageType);
        File file = fileStorage.download(fileKey);

        
        try (FileInputStream in = new FileInputStream(file)){
            OutputStream out = response.getOutputStream();
            byte[] buffer = new byte[1024];
            while (in.read(buffer) != -1) {
                out.write(buffer);
                out.flush();
            }
            // TODO 设置响应头
            response.setHeader("Content-Disposition", "attachment;filename=" + file.getName());
            response.setContentType("application/octet-stream");
        } catch (IOException e) {
           throw new FileStorageException("下载失败", e);
        }
    }

}
