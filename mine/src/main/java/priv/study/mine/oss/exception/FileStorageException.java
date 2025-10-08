package priv.study.mine.oss.exception;

/**
 * 文件异常类
 * 
 * @author JLian
 * @date 2025年10月07日
 */
public class FileStorageException extends RuntimeException{

    private static final long serialVersionUID = -828583654531532L;

    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
