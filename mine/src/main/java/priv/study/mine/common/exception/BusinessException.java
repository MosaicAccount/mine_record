package priv.study.mine.common.exception;

import priv.study.mine.common.ModuleEnum;

import java.io.Serial;

/**
 * 业务异常类
 *
 * @author JLian
 * @version 0.0.1
 * @since 0.0.1
 */
public class BusinessException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1630381682342997816L;

    private final String module;

    private final String errorMessage;

    public BusinessException(ModuleEnum module, ErrorEnum error) {
        super(error.getMessage());
        this.module = module.getModule();
        this.errorMessage = error.getMessage();
    }

    @Override
    public String toString() {
        return String.format("BusinessException{module=%s, errorMessage='%s'}",
                module, errorMessage);
    }

}
