package com.cloud.security.dto;

import com.cloud.security.enums.ResponseEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 响应实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable {

    private T data;
    private Integer code;
    private String msg;

    public static <T> Result<T> succeed(String msg) {
        return succeedWith(null, ResponseEnum.R200.getCode(),msg);
    }

    public static <T> Result<T> succeed(T data, String msg) {
        return succeedWith(data, ResponseEnum.R200.getCode(),msg);
    }

    public static <T> Result<T> succeed(int code, String msg) {
        return succeedWith(null, code,msg);
    }

    public static <T> Result<T> succeedWith(T data, Integer code,String msg) {
        return new Result<>(data, code, msg);
    }

    public static <T> Result<T> failed(String msg) {
        return failedWith(null, ResponseEnum.E100.getCode(), msg);
    }

    public static <T> Result<T> failed(int code, String msg) {
        return failedWith(null, code,msg);
    }

    public static <T> Result<T> failed(T model,String msg) {
        return failedWith(model, ResponseEnum.E100.getCode(), msg);
    }

    public static <T> Result<T> failedWith(T data, Integer code, String msg) {
        return new Result<>( data, code, msg);
    }

}
