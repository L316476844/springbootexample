package org.jon.lv.result;

import java.io.Serializable;

/**
 * @Package org.jon.lv.result.ResultDO
 * Author lv bin
 * @date 2017/5/16 13:29
 * version V1.0.0
 */
public class ResultDO<T> implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4227833010077730477L;

    /**
     * 是否成功，默认失败
     */
    private boolean success = false;

    /**
     * 返回消息
     */
    private String errMsg;

    /**
     * 返回CODE
     */
    private int errCode;

    /**
     * 返回结果封装器
     */
    private T data;


    public boolean isSuccess() {
        return success;
    }


    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}