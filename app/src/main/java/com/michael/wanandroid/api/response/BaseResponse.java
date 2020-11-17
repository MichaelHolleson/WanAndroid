package com.michael.wanandroid.api.response;

public class BaseResponse<T> {
    public int errorCode;

    public String errorMsg;

    public T data;
    
    @Override
    public String toString() {
        return "BaseResponse{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
