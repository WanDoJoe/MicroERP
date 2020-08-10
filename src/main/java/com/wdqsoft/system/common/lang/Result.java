package com.wdqsoft.system.common.lang;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
//    private int code;
    private int rc;
    private String acc_Token;
    private String rm;
//    private String msg;
    private Object data;
    public static Result success(Object data){
        return success(200,"成功",data);

    }
    public static Result success(int rc,String rm,Object data){
        Result result=new Result();
        result.rc=rc;
        result.rm=rm;
        result.data=data;

        return result;
    }
    public static Result fail(int code ,String msg){
        JSONObject jsonObject=new JSONObject();

        return fail(code,msg,jsonObject);
    }

    public static Result fail(int rc ,String rm,Object data){
        Result result=new Result();
        result.rc=rc;
        result.rm=rm;
        result.data=data;
        return result;
    }
}
