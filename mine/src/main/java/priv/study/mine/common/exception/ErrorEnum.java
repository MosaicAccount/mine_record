package priv.study.mine.common.exception;

import lombok.Data;

/**
 * 业务异常枚举类
 *
 * @author JLian
 * @version 0.0.1
 * @since 0.0.1
 */
public enum ErrorEnum {
    ;


    private String message;


    ErrorEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
