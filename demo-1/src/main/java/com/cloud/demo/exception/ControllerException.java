package com.cloud.demo.exception;
/**
 * controller层异常
 */
public class ControllerException extends BaseException {

    public ControllerException(String msg) {
        super(msg);
    }

    public ControllerException(Exception e) {
        this(e.getMessage());
    }

}