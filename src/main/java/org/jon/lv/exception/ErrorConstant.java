package org.jon.lv.exception;

/**
 * @Description: 错误对照码
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/17 9:43
 * version V1.0.0
 */
public enum ErrorConstant {
    BAD_REQUEST(400, "Bad Request!"),
    NOT_AUTHORIZATION(401, "NotAuthorization"),
    NOT_FOUND_REQUEST(404, "Not Found Request Path"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    NOT_ACCEPTABLE(406, "Not Acceptable"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

    LOGIN_FIRST(999, "[服务器]请登录"),

    RUNTIME_EXCEPTION(1000, "[服务器]运行时异常"),
    NULL_POINTER_EXCEPTION(1001, "[服务器]空值异常"),
    CLASS_CAST_EXCEPTION(1002, "[服务器]数据类型转换异常"),
    IO_EXCEPTION(1003, "[服务器]IO异常"),
    NO_SUCH_METHOD_EXCEPTION(1004, "[服务器]未知方法异常"),
    INDEX_OUT_OF_BOUNDS_EXCEPTION(1005, "[服务器]数组越界异常"),
    CONNECT_EXCEPTION(1006, "[服务器]网络异常"),
    ERROR_MEDIA_TYPE(1007, "[服务器]Content-type错误，请使用application/json"),
    EMPTY_REQUEST_BOYD(1008, "[服务器]request请求body不能为空"),
    ERROR_REQUEST_BOYD(1009, "[服务器]request请求body非json对象"),
    ERROR_VERSION(2000, "[服务器]版本号错误"),
    ERROR_FORMAT_PARAMETER(2001, "[服务器]参数格式错误");



    private final int code;
    private final String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ErrorConstant(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (ErrorConstant constant : ErrorConstant.values()) {
                if (constant.code == value) {
                    return constant.msg;
                }
            }
        }
        return "";
    }

    public ErrorConstant getTypeByValue(int value) {
        for (ErrorConstant constant : ErrorConstant.values()) {
            if (constant.code == value) {
                return constant;
            }
        }
        return null;
    }

}
