package priv.study.mine.common.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import priv.study.mine.common.entity.R;

/**
 * 全局异常处理类
 *
 * @author JLian
* @date 2025年10月04日
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R<Void> handleBusinessException(BusinessException e, WebRequest request) {
        String url = getRequestPath(request);
        log.error("业务异常：module = {}, url = {}，message = {}", e.getModule(), url, e.getMessage(), e);
        return R.error(e.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public R<Void> handleException(Exception e, WebRequest request) {
         String url = getRequestPath(request);
        log.error("系统异常：url = {}，message = {}", url, e.getMessage(), e);
        return R.error();
    }

    /**
     * 获取请求路径
     */
    private String getRequestPath(WebRequest request) {
        if (request instanceof ServletWebRequest) {
            HttpServletRequest servletRequest = ((ServletWebRequest) request).getRequest();
            return servletRequest.getRequestURI();
        }
        return "";
    }
}
