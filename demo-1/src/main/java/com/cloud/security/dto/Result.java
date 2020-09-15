package com.cloud.security.dto;



import com.cloud.security.enums.ResponseMessage;
import lombok.Builder;
import lombok.Data;

/**
 * 通用response
 */

@Data
@Builder
public class Result {

    /**
     * 状态
     */
    private int code;

    /**
     * 错误消息
     */
    private String msg;

    /**
     * 返回对象
     */
    private Object body;

    /**
     * 无异常返回
     */
    public static Result ok (){
        return Result.builder().code(ResponseMessage.R000.getCode()).msg(ResponseMessage.R000.getMsg()).body("").build();
    }

    public static Result ok (Object body){
        return Result.builder().code(ResponseMessage.R000.getCode()).msg(ResponseMessage.R000.getMsg()).body(body).build();
    }

    /***
     * 有异常返回
     */
    public static Result error (){
        return Result.builder().code(ResponseMessage.R111.getCode()).msg(ResponseMessage.R111.getMsg()).body("").build();
    }
    public static Result error (Object body){
        return Result.builder().code(ResponseMessage.R111.getCode()).msg(ResponseMessage.R111.getMsg()).body(body).build();
    }
}