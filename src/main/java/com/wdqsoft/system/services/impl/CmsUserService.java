package com.wdqsoft.system.services.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wdqsoft.system.common.lang.Result;
import com.wdqsoft.system.common.lang.ResultCode;
import com.wdqsoft.system.database.cms.mybatis.cmsh2db.CmsUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CmsUserService extends CmsBaseService{

    @Autowired
    CmsUserMapper cmsUserMapper;

    @Override
    protected Result selectByAllList(JSONObject object) {
        String start=object.getString("start");
        String count=object.getString("count");//也是end
        PageHelper.startPage(Integer.valueOf(start),Integer.valueOf(count));
        try {
        PageInfo pageInfo=new PageInfo(cmsUserMapper.selectByPageinfo());
            return Result.success(pageInfo);
        }catch (Exception e){
           return Result.fail(ResultCode.UNKNOWERROR,e.getMessage());
        }
    }

    @Override
    protected Result updateByJsonString(JSONObject object) {


        return super.updateByJsonString(object);
    }

    @Override
    protected Result selectByJsonString(JSONObject object) {


        return super.selectByJsonString(object);
    }


    @Override
    protected Result insertByJsonString(JSONObject object) {


        return super.insertByJsonString(object);
    }

}
