package com.javasm.demo.entity;

public enum ResponseEnum {
    SUCCESS(200,"查询成功"),
    ERROR(409,"查询失败");
    private Integer code;
    private String msg;

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
