package com.test.model.base.out;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lu.feng
 */
@Data
public class HttpResponse<T> implements Serializable {

    private static final long serialVersionUID = 6011899740531371648L;
    private String errcode = "0";
    private T data;
    private String errmsg;


    public static <T>  HttpResponse<T> success(T data) {
        HttpResponse<T> result = new HttpResponse<>();
        result.setData(data);
        return result;
    }
    public static <T>  HttpResponse<T> successWithMsg(String errmsg) {
        HttpResponse<T> result = new HttpResponse<>();
        result.setErrmsg(errmsg);
        return result;
    }

    public static <T>  HttpResponse<T> fail(String errmsg) {
        return fail(null,"1",errmsg);
    }

    public static <T>  HttpResponse<T> noPermission() {
        return fail(null,"403","抱歉，你无权访问");
    }


    public static <T>  HttpResponse<T> fail(T data,String errmsg) {
        return fail(data,"1",errmsg);
    }

    public static <T>  HttpResponse<T> fail(T data,String errcode,String errmsg) {
        HttpResponse<T> result = new HttpResponse<>();
        result.setData(data);
        result.setErrcode(errcode);
        result.setErrmsg(errmsg);
        return result;
    }

}
