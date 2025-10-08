package priv.study.mine.oss.utils;

import java.util.UUID;

/**
 * 文件工具类
 * 
 * @author JLian
 * @date 2025年10月08日
 */
public class FileUtils {

    /**
     * 生成文件Key
     * 
     * @param originalFilename 文件名
     * @return 文件Key
     */
    public static String generateFileKey(String originalFilename) {
        String suffix = "";
        if (originalFilename != null && originalFilename.contains(".")) {
            suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        }
        return UUID.randomUUID().toString().replace("-", "") + suffix;
    }
}