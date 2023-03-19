package com.fzu.hqh.dto;

public class Page {
    String result;
    Object data;
    String message;
    Pager pager;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    @Override
    public String toString() {
        return "Page{" +
                "result='" + result + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                ", pager=" + pager +
                '}';
    }
}