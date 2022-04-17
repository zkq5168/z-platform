package com.zkq.platform.webcommon.entity;

import lombok.Data;

import java.util.List;

/**
 * 封装的结果类
 * @author zkq
 * @date 2022-04-11
 */
@Data
public class Result<T> {
    private int code;           //结果码（0：成功，-1：失败，400：未授权）
    private String message;     //结果消息
    private T data;             //返回的结果
    private List<T> dataList;   //返回的结果集

    /**
     * 处理成功
     * @return
     */
    public static Result success(){
        Result result = new Result();
        result.code = 0;
        result.message = "成功";
        return result;
    }

    /**
     * 处理成功
     * @param data
     * @return
     */
    public static <T> Result success(T data){
        Result result = new Result();
        result.code = 0;
        result.message = "成功";
        result.data = data;
        return result;
    }

    /**
     * 处理成功
     * @param dataList
     * @return
     */
    public static <T> Result success(List<T> dataList){
        Result result = new Result();
        result.code = 0;
        result.message = "成功";
        result.dataList = dataList;
        return result;
    }

    /**
     * 处理失败
     * @param message
     * @return
     */
    public static <T> Result fail(Object message){
        Result result = new Result();
        result.code = -1;
        result.message = String.valueOf(message);
        return result;
    }

    /**
     * 未授权
     * @return
     */
    public static Result noAuth(){
        Result result = new Result();
        result.code = 400;
        result.message = "未授权";
        return result;
    }
}
