package com.leslie.common.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseData<T> {

    private RESPONSE_CODE_ENUM code;
    private String msg;
    //private String msgDetail; //不使用，错误信息直接msg,具体有需求再使用
    private T data;

    // 构造方法 -- start

    public ResponseData(RESPONSE_CODE_ENUM code) {
        this.code = code;
        this.msg = code.getDescription();
    }

    public ResponseData(RESPONSE_CODE_ENUM code, T data) {
        this(code);
        this.data = data;
    }

    public ResponseData(RESPONSE_CODE_ENUM code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /*public ResponseData(RESPONSE_CODE_ENUM code, String msg, String msgDetail, T data) {
        this.code = code;
        this.msg = msg;
        this.msgDetail = msgDetail;
        this.data = data;
    }*/

    // 构造方法 -- end

    //---------------------------------------------------

    // 静态方法 -- start

    public static <T> ResponseData<T> success() {
        return new ResponseData<>(RESPONSE_CODE_ENUM.SUCCESS);
    }

    public static <T> ResponseData<T> success(T data) {
        return new ResponseData<>(RESPONSE_CODE_ENUM.SUCCESS,
                RESPONSE_CODE_ENUM.SUCCESS.getDescription(),
                data);
    }

    public static <T> ResponseData<T> failure() {
        return new ResponseData<>(RESPONSE_CODE_ENUM.FAILURE);
    }

    public static <T> ResponseData<T> failure(String msg) {
        return new ResponseData<>(RESPONSE_CODE_ENUM.FAILURE,
                msg,
                null);
    }

    public static <T> ResponseData<T> error() {
        return new ResponseData<>(RESPONSE_CODE_ENUM.ERROR);
    }

    public static <T> ResponseData<T> error(String msg) {
        return new ResponseData<>(RESPONSE_CODE_ENUM.ERROR,
                msg,
                null);
    }

    public static <T> ResponseData<T> badRequest(String msg) {
        return new ResponseData<>(RESPONSE_CODE_ENUM.BAD_REQUEST,
                msg,
                null);
    }

    public static <T> ResponseData<T> fallback() {
        return new ResponseData<>(RESPONSE_CODE_ENUM.FALLBACK);
    }

    public static <T> ResponseData<T> fallback(String msg) {
        return new ResponseData<>(RESPONSE_CODE_ENUM.FALLBACK, msg, null);
    }

    // 静态方法 -- end
}
