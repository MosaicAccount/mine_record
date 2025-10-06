package priv.study.mine.common.exception;

import priv.study.mine.common.enumerate.ModuleEnum;

import java.io.Serial;

import lombok.Getter;

/**
 * 业务异常类
 *
 * @author JLian
* @date 2025年10月04日
 */
@Getter
public class BusinessException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1630381682342997816L;

    private final String module;

    private final String errorMessage;

    public BusinessException(ModuleEnum module, String errorMessage) {
        super(errorMessage);
        this.module = module.getModule();
        this.errorMessage = errorMessage;
    }

    public BusinessException(ModuleEnum module, ErrorEnum error) {
        super(error.getMessage());
        this.module = module.getModule();
        this.errorMessage = error.getMessage();
    }

    public BusinessException(ModuleEnum module, String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.module = module.getModule();
        this.errorMessage = errorMessage;
    }


    public BusinessException(ModuleEnum module, ErrorEnum error, Throwable cause) {
        super(error.getMessage(), cause);
        this.module = module.getModule();
        this.errorMessage = error.getMessage();
    }

    @Override
    public String toString() {
        return String.format("BusinessException{module=%s, errorMessage='%s'}",
                module, errorMessage);
    }

}
