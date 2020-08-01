package com.cloud.demo.exception;

/**
 * service层异常
 */
public class ServiceException extends BaseException {

    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(Exception e){
        this(e.getMessage());
    }
}
