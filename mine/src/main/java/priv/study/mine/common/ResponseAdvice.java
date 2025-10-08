package priv.study.mine.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import priv.study.mine.common.entity.R;

/**
 * 统一结果返回
 *
 * @author JLian
 * @date 2025年10月04日
 */
@RestControllerAdvice
@Slf4j
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return !returnType.hasMethodAnnotation(NoResponseBody.class) && !returnType.getParameterType().equals(R.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
            Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
            ServerHttpResponse response) {
        log.info("接口返回结果为：{}", body);

        if (returnType.getParameterType().equals(R.class)) {
            return body;
        }

        if (returnType.getParameterType().equals(Void.class)) {
            return R.success();
        }

        if (returnType.getGenericParameterType().equals(String.class)) {
            try {
                return objectMapper.writeValueAsString(R.success(body));
            } catch (Exception e) {
                log.error("返回结果转换异常", e);
                return R.error("返回结果转换异常");
            }
        }

        return R.success(body);
    }
}
