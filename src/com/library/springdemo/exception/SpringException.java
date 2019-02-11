package com.library.springdemo.spring.exception;

/**
 * Created by ibrahimg on 09.11.2018.
 */
public class SpringException extends RuntimeException {

    private String exceptionMsg;
    private Object lastModel;

    public SpringException(String exceptionMsg){
        this.exceptionMsg = exceptionMsg;
    }

    public SpringException(String exceptionMsg, Object lastModel){
        this.exceptionMsg = exceptionMsg;
        this.lastModel = lastModel;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }


    public Object getLastModel() {
        return lastModel;
    }

    public void setLastModel(Object lastModel) {
        this.lastModel = lastModel;
    }
}
