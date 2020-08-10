package com.wdqsoft.system.services.interf;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.wdqsoft.system.common.lang.Result;

public abstract interface BaseService<T> {
    Result selectByIdFromOne(int id);
    Result sleectByIdFromList(int id);
    Result selectByKeyFromOne(String id);
    Result sleectByKeyFromList(String id);
    Result sleectByJsonString(JSONObject object);


    Result updateByKey(T t);
    Result updateByJsonString(JSONObject object);

    Result deleteById(int id);
    Result deleteByKey(String key);
    Result deleteByObject(T t);
    Result deleteByJsonString(JSONObject object);


    Result insertByObject(T t);
    Result insertByJsonString(JSONObject object);

}
