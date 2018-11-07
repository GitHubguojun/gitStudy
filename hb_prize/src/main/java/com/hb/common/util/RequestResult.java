package com.hb.common.util;

import java.io.Serializable;

/**
 * @Description: 公共返回参数
 */
public class RequestResult<T> implements Serializable {
    /**
     * 异常编码
     **/
    public static final int CODE_EXCEPTION = 1;

    /**
     * 正常编码
     **/
    public static final int CODE_NORMAL = 0;

    /**
     * 警告编码
     **/
    public static final int CODE_WARN = 2;

    /**
     * 逻辑错误编码
     */
    public static final int CODE_LOGIC_ERROR = 4;

    /**
     * 错误编码
     */
    private int ret=CODE_NORMAL;

    /**
     * 成功标识
     */
    private boolean isSuccess = true;

    /**
     * 错误消息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public RequestResult() {

    }

    public RequestResult(boolean isSuccess, String msg, T data) {
        this(isSuccess,CODE_NORMAL,msg,data);
    }

    public RequestResult(boolean isSuccess,int ret, String msg,T data) {
        this.isSuccess = isSuccess;
        this.ret=ret;
        this.msg = msg;
        this.data = data;
    }

    public void setSuccessResult(String msg,T data) {
        this.isSuccess = true;
        this.ret=CODE_NORMAL;
        this.msg = msg;
        this.data=data;
    }

    public void setFailResult(int ret, String msg) {
        this.isSuccess = false;
        this.ret=ret;
        this.msg = msg;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
