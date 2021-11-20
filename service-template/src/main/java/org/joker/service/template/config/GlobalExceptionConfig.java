package org.joker.service.template.config;

import org.joker.service.template.core.ResponseBodyEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionConfig {

    @ExceptionHandler
    public ResponseBodyEntity handler(Exception e) {
        return ResponseBodyEntity.failure().setMessage(e.getMessage());
    }

}
