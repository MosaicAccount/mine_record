package priv.study.mine.oss.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import priv.study.mine.oss.StorageType;

/**
 * @author JLian
 * @date 2025年10月07日
 */
@ConfigurationProperties(prefix = "file.storage")
@Data
public class FileStorageProperties {

    private StorageType defaultType = StorageType.LOCAl;

    private LocalFileConfig local = new LocalFileConfig();

    private MinioConfig minio = new MinioConfig();


    @Data
    public static class LocalFileConfig {
    
        /**
         * 是否启用
         */
        private Boolean enabled = true;

        /**
         * 文件存储路径
         */
        private String basePath = "./tmp";

        /**
         * 自动创建目录
         */
        private Boolean autoCreateDir = true;


        private String baseUrl = "/files";
    }

    @Data
    public static class MinioConfig {
        /**
         * 是否启用MinIO存储
         */
        private Boolean enabled = false;
        
        /**
         * MinIO服务地址
         */
        private String endpoint;
        
        /**
         * 访问密钥
         */
        private String accessKey;
        
        /**
         * 秘密密钥
         */
        private String secretKey;
        
        /**
         * 默认桶名称
         */
        private String defaultBucket = "default";
        
        /**
         * 区域
         */
        private String region = "";
        
        /**
         * 是否启用HTTPS
         */
        private Boolean secure = false;
        
        /**
         * 连接超时时间(毫秒)
         */
        private Long connectTimeout = 30000L;
        
        /**
         * 读写超时时间(毫秒)
         */
        private Long writeTimeout = 60000L;
        
        /**
         * 最大重试次数
         */
        private Integer maxRetries = 3;
        
        /**
         * 是否启用路径风格访问
         */
        private Boolean pathStyleAccess = true;
    }

}
