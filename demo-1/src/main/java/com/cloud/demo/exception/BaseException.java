package com.cloud.demo.exception;

import java.io.Serializable;

/**
 * 基本异常，系统定义的所有异常都需要继承这个基本类
 */
public class BaseException extends RuntimeException{

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(Exception e){
        this(e.getMessage());
    }
}
