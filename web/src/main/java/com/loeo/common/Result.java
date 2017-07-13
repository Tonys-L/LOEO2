package com.loeo.common;

import java.io.Serializable;

/**
 * Created by LOEO on 2017/07/12 20:07
 */
public class Result implements Serializable {
    private Boolean success;
    private String msg;
    private Object data;

    private Result() {

    }

    public static Result buildSuccess() {
        return new ResultBuilder().setSuccess(true).build();
    }

    public static Result buildSuccess(Object data) {
        return new ResultBuilder().setSuccess(true).setData(data).build();
    }

    public static Result buildFailed(String msg) {
        return new ResultBuilder().setSuccess(false).setMsg(msg).build();
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private static class ResultBuilder {
        private Result result = new Result();

        public Result build() {
            return result;
        }

        public ResultBuilder setMsg(String msg) {
            result.setMsg(msg);
            return this;
        }

        public ResultBuilder setData(Object data) {
            result.setData(data);
            return this;
        }

        public ResultBuilder setSuccess(Boolean success) {
            result.setSuccess(success);
            return this;
        }

    }
}
