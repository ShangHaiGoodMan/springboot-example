package com.cloud.security.handler;

import com.cloud.security.dto.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    /**
     * 全局默认异常
     */
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result defaultException(Exception e) {
        return Result.error(e.toString());
    }

    /**
     * 非法参数异常
     */
    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result defaultException(IllegalArgumentException e) {
        return Result.error(e.toString());
    }

    /**
     * 数据校验异常
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result badRequestException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> errors = bindingResult.getFieldErrors();
        String errorMessage = errors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
        return Result.error(errors.get(0).getDefaultMessage());
    }

    /**
     * 请求报文非法
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result bindException(HttpMessageNotReadableException e) {
        return Result.error(e.toString());
    }
}
