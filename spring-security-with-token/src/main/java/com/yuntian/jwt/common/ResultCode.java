package com.yuntian.jwt.common;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS(200, "成功"),
    /**
     * 失败
     */
    FAIL(400, "参数有误"),
    /**
     * 未登录
     */
    UN_LOGIN(401, "登录失效"),
    /**
     * 没有权限
     */
    UN_AUTHORITY(402, "无访问接口的权限"),
    /**
     * 接口不存在
     */
    NOT_FOUND(404, "接口不存在"),
    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(500, "服务器内部错误");

    private final int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}
