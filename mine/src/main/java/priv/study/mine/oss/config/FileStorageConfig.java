package priv.study.mine.oss.config;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import priv.study.mine.oss.factory.FileStorageFactory;
import priv.study.mine.oss.service.FileStorageValidator;
import priv.study.mine.oss.strategy.FileStorage;
import priv.study.mine.oss.strategy.impl.LocalFileStorage;

/**
 * 文件存储平台配置类
 * 
 * @author JLian
 * @date 2025年10月07日
 */
@Configuration
@EnableConfigurationProperties(FileStorageProperties.class)
@Slf4j
public class FileStorageConfig {

    @Bean
    @ConditionalOnMissingBean
    public FileStorageFactory fileStorageFactory(List<FileStorage> fileStorageList) {
        return new FileStorageFactory(fileStorageList);
    }

    @Bean 
    public FileStorageValidator fileStorageValidator(FileStorageProperties properties) {
        return new FileStorageValidator(properties);
    }

    @Bean
    @ConditionalOnProperty(name = "file.storage.local.enabled", havingValue = "true")
    @ConditionalOnMissingBean(name = "localFileStorage")
    public LocalFileStorage createLocalFileStorage(FileStorageProperties properties) {
        String basePath = properties.getLocal().getBasePath();
        log.info("初始化本地文件存储，基础目录为：{}",basePath);
        return new LocalFileStorage(basePath);
    }

    
}
