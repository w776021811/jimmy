package com.jimmy.frame.utils;

import com.baomidou.mybatisplus.extension.api.IErrorCode;

/**
 * @version: V1.0
 * @author: Zhongyuna Wang
 * @className: SimpleError
 * @description: 异常返回码
 * @data: 2018-08-17 07:41
 **/
public enum SimpleError implements IErrorCode {

    DB_RESOURCE_NULL("400","数据库中没有该资源"),
    NO_PERMITION("403", "权限异常"),
    REQUEST_INVALIDATE("400","请求数据格式不正确"),
    INVALID_KAPTCHA("400","验证码不正确"),
    CANT_DELETE_ADMIN("600","不能删除超级管理员"),
    CANT_FREEZE_ADMIN("600","不能冻结超级管理员"),
    CANT_CHANGE_ADMIN("600","不能修改超级管理员角色"),
    MENU_PCODE_COINCIDENCE("400","菜单编号和副编号不能一致"),
    EXISTED_THE_MENU("400","菜单编号重复，不能添加"),
    DICT_MUST_BE_NUMBER("400","字典的值必须为数字"),
    REQUEST_NULL("400", "请求有错误"),
    SESSION_TIMEOUT("400", "会话超时"),
    SERVER_ERROR("500", "服务器异常"),
    BPERROR("001", "失败");

    private String code;
    private String msg;

    SimpleError(final String code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
