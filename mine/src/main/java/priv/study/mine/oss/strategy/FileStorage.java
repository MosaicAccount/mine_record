package priv.study.mine.oss.strategy;

import java.io.File;
import java.time.Duration;

import priv.study.mine.oss.StorageType;
import priv.study.mine.oss.exception.FileStorageException;
import priv.study.mine.oss.model.FileUploadRequest;

/**
 * 文件存储平台接口
 * 
 * @author JLian
 * @date 2025年10月07日
 */
public interface FileStorage {
    
    /**
     * 存储文件
     */
    String upload(FileUploadRequest request) throws FileStorageException
    ;
    
    /**
     * 下载文件
     */
    File download(String fileKey) throws FileStorageException;
    
    /**
     * 获取文件访问URL
     */
    String getUrl(String fileKey, Duration expiry);
    
    /**
     * 删除文件
     */
    boolean delete(String fileKey) throws FileStorageException;
    
    /**
     * 判断文件是否存在
     */
    boolean exists(String fileKey);
    
    /**
     * 存储类型
     */
    StorageType getStorageType();

}
