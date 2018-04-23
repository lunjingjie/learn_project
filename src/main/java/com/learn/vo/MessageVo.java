package com.learn.vo;

public class MessageVo {

    private String code;

    private String result;

    private Object data;

    public MessageVo() {

    }

    public MessageVo(String code, String result) {
        this.code = code;
        this.result = result;
    }

    public MessageVo(String code, String result, Object data) {
        this.code = code;
        this.result = result;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
