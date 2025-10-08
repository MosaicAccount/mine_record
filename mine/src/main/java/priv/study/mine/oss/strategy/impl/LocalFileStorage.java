package priv.study.mine.oss.strategy.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import priv.study.mine.oss.StorageType;
import priv.study.mine.oss.exception.FileStorageException;
import priv.study.mine.oss.model.FileUploadRequest;
import priv.study.mine.oss.strategy.FileStorage;
import priv.study.mine.oss.utils.FileUtils;

/**
 * 本地文件存储
 * 
 * @author JLian
 * @date 2025年10月07日
 */
@Slf4j
public class LocalFileStorage implements FileStorage {

    private final String basePath;

    public LocalFileStorage(String basePath) {
        this.basePath = basePath;
    }

    @Override
    public String upload(FileUploadRequest request) throws FileStorageException {
        MultipartFile file = request.getFile();
        // 创建文件名
        String fileKey = FileUtils.generateFileKey(file.getOriginalFilename());
        try {
            Path filePath = Paths.get(basePath, fileKey);
            // 保证目录存在
            Files.createDirectories(filePath.getParent());

            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            log.info("文件已保存至{}", filePath);
            return fileKey;
        } catch (IOException e) {
            throw new FileStorageException("", e);
        }
    }

    @Override
    public File download(String fileKey) throws FileStorageException {
        Path filePath = Paths.get(basePath, fileKey);
        if (!Files.exists(filePath)) {
            throw new FileStorageException("文件不存在: " + fileKey);
        }
        return filePath.toFile();
    }
    
    @Override
    public String getUrl(String fileKey, Duration expiry) {
        // 本地文件返回文件路径或通过HTTP服务访问的URL
        return "file://" + Paths.get(basePath, fileKey).toString();
    }
    
    @Override
    public boolean delete(String fileKey) throws FileStorageException {
        try {
            Path filePath = Paths.get(basePath, fileKey);
            return Files.deleteIfExists(filePath);
        } catch (IOException e) {
            throw new FileStorageException("文件删除失败", e);
        }
    }

    @Override
    public boolean exists(String fileKey) {
        return Files.exists(Paths.get(basePath, fileKey));
    }

    @Override
    public StorageType getStorageType() {
        return StorageType.LOCAl;
    }

}
