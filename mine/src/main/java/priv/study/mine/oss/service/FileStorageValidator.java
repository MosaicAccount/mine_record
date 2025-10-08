package priv.study.mine.oss.service;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

import priv.study.mine.oss.StorageType;
import priv.study.mine.oss.config.FileStorageProperties;
import priv.study.mine.oss.config.FileStorageProperties.LocalFileConfig;

/**
 * 文件存储验证器
 * 
 * @author JLian
 * @date 2025年10月07日
 */
public class FileStorageValidator {

    private final FileStorageProperties properties;


    public FileStorageValidator(FileStorageProperties properties) {
        this.properties = properties;
        validateFileConfig();
    }

    /**
     * 校验文件配置
     */
    private void validateFileConfig() {
        // 检查默认存储配置是否启用
        StorageType storageType = properties.getDefaultType();
        if (!isDefaultStorageEnabled(storageType)) {
            throw new RuntimeException("默认存储未启用");
        }
        // 检查本地配置
        validateLocalConfig(properties.getLocal());

    }

    /**
     * 检查默认存储是否启用
     */
    private boolean isDefaultStorageEnabled(StorageType storageType) {
        switch (storageType) {
            case LOCAl:
                return properties.getLocal().getEnabled();
            case MINIO:
                return properties.getMinio().getEnabled();
            default:
                return false;
        }
    }

    private void validateLocalConfig(LocalFileConfig config) {
        if (StringUtils.isBlank(config.getBasePath())) {
            throw new IllegalStateException("本地存储基础目录不能为空");
        }
        
        // 检查目录是否可写
        File baseDir = new File(config.getBasePath());
        if (config.getAutoCreateDir() && !baseDir.exists()) {
            if (!baseDir.mkdirs()) {
                throw new IllegalStateException("无法创建本地存储目录: " + config.getBasePath());
            }
        }
        
        if (!baseDir.canWrite()) {
            throw new IllegalStateException("本地存储目录不可写: " + config.getBasePath());
        }
    }
}
