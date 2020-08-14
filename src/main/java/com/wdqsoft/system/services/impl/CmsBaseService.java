package com.wdqsoft.system.services.impl;

import com.alibaba.fastjson.JSONObject;
import com.wdqsoft.system.common.lang.Result;
import com.wdqsoft.system.services.interf.BaseService;

public abstract class CmsBaseService<T> {
    //模板设计模式
    public   Result selectByIdFromOne(int id){
        throw new UnsupportedOperationException();
    }
    public   Result selectByIdFromList(int id){
        throw new UnsupportedOperationException();
    }
    public   Result selectByAllList(JSONObject object){
        throw new UnsupportedOperationException();
    }
    public   Result selectByKeyFromOne(String id){
        throw new UnsupportedOperationException();
    }
    public   Result selectByKeyFromList(String id){
        throw new UnsupportedOperationException();
    }
    public   Result selectByJsonString(JSONObject object){
        throw new UnsupportedOperationException();
    }


    public   Result updateByKey(T t){
        throw new UnsupportedOperationException();
    }
    public   Result updateByJsonString(JSONObject object){
        throw new UnsupportedOperationException();
    }

    public   Result deleteById(int id){
        throw new UnsupportedOperationException();
    }
    public   Result deleteByKey(String key){
        throw new UnsupportedOperationException();
    }
    public   Result deleteByObject(T t){
        throw new UnsupportedOperationException();
    }
    public    Result deleteByJsonString(JSONObject object){
        throw new UnsupportedOperationException();
    }


    public   Result insertByObject(T t){
        throw new UnsupportedOperationException();
    }
    public   Result insertByJsonString(JSONObject object){
        throw new UnsupportedOperationException();
    }
}
