package com.jimmy.frame.utils;

/**
 * @version: V1.0
 * @author: Zhongyuna Wang
 * @className: SimpleCode
 * @description: 返回码
 * @data: 2018-08-17 07:41
 **/
public enum SimpleCode {

     SUCCESS("000", "成功"),
     ERROR("001", "失败"),
     BPSUCCESS("success", "true"),
     BPMESSAGE("message", "上传成功"),
     BPERROR("success", "true"),
     BPERRORMESSAGE("message", "上传成功");



    private String  code;
    private String msg;

    SimpleCode(String code, String message) {
        this.code = code;
        this.msg = message;
    }

    @Override
    public String toString() {
        return msg;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return msg;
    }
}
