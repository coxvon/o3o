package org.cv.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.cv.web.model.R;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Log4j2
@RestControllerAdvice(basePackages = "org.cv.web.controller")
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        log.info(body);
        return switch (body) {
            case null -> null;
            case Boolean flag -> flag ? R.ok("操作成功") : R.fail("操作失败");
            case String info -> {
                try {
                    yield objectMapper.writeValueAsString(R.ok(info));
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
            default -> R.ok(body);
        };
    }

}
