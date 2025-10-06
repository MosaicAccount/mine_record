package priv.study.mine.common.exception;

import lombok.Getter;

/**
 * 业务异常枚举类
 *
 * @author JLian
* @date 2025年10月04日
 */
@Getter
public enum ErrorEnum {
    DATA_NOT_EXIST("数据不存在"),
    SAVE_FAIL("保存失败"),
    DELETE_FAIL("删除失败"),
    UPDATE_FAIL("更新失败"),
    ;

    private final String message;


    ErrorEnum(String message) {
        this.message = message;
    }

}
