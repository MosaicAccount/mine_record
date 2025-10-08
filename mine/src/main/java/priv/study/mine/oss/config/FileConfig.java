package priv.study.mine.oss.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 文件映射配置
 * 
 * @author JLian
 * @date 2025年10月08日
 */
@Configuration
public class FileConfig implements WebMvcConfigurer{

    @Autowired
    private FileStorageProperties properties;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String basePath = properties.getLocal().getBasePath();
        String baseUrl = properties.getLocal().getBaseUrl();
        registry.addResourceHandler(baseUrl + "/**")
                .addResourceLocations("file:" + basePath + "/");
    }


    
}
