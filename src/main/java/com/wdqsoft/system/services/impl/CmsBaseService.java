package com.wdqsoft.system.services.impl;

import com.alibaba.fastjson.JSONObject;
import com.wdqsoft.system.common.lang.Result;
import com.wdqsoft.system.services.interf.BaseService;

public abstract class CmsBaseService<T> {
    //模板设计模式
    protected   Result selectByIdFromOne(int id){
        throw new UnsupportedOperationException();
    }
    protected   Result selectByIdFromList(int id){
        throw new UnsupportedOperationException();
    }
    protected   Result selectByAllList(JSONObject object){
        throw new UnsupportedOperationException();
    }
    protected   Result selectByKeyFromOne(String id){
        throw new UnsupportedOperationException();
    }
    protected   Result selectByKeyFromList(String id){
        throw new UnsupportedOperationException();
    }
    protected   Result selectByJsonString(JSONObject object){
        throw new UnsupportedOperationException();
    }


    protected   Result updateByKey(T t){
        throw new UnsupportedOperationException();
    }
    protected   Result updateByJsonString(JSONObject object){
        throw new UnsupportedOperationException();
    }

    protected   Result deleteById(int id){
        throw new UnsupportedOperationException();
    }
    protected   Result deleteByKey(String key){
        throw new UnsupportedOperationException();
    }
    protected   Result deleteByObject(T t){
        throw new UnsupportedOperationException();
    }
    protected    Result deleteByJsonString(JSONObject object){
        throw new UnsupportedOperationException();
    }


    protected   Result insertByObject(T t){
        throw new UnsupportedOperationException();
    }
    protected   Result insertByJsonString(JSONObject object){
        throw new UnsupportedOperationException();
    }
}
