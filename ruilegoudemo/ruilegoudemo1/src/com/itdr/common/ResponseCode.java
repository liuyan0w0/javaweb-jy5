package com.itdr.common;

public class ResponseCode<T>  {
    private  Integer status;
    private T data;//如何保证是数组，就放数据，是对象就放对象
    private  String mag;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    //成功返回状态码和成功获取的数据
    //失败返回状态和失败信息

    @Override
    public String toString() {
        return "ResponseCode{" +
                "status=" + status +
                ", data=" + data +
                ", mag='" + mag + '\'' +
                '}';
    }
}
