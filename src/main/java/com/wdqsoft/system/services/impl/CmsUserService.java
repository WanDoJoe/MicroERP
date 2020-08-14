package com.wdqsoft.system.services.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wdqsoft.system.common.lang.HttpUtils;
import com.wdqsoft.system.common.lang.Result;
import com.wdqsoft.system.common.lang.ResultCode;
import com.wdqsoft.system.database.cms.bean.CmsUser;
import com.wdqsoft.system.database.cms.mybatis.cmsh2db.CmsUserMapper;
import com.wdqsoft.system.jwt.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@Service
public class CmsUserService extends CmsBaseService{
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    CmsUserMapper cmsUserMapper;


    public Result Login(JSONObject object ,HttpServletResponse response) {

        String loginname=object.getString("loginname");
        String passwd=object.getString("passwd");

        CmsUser user = cmsUserMapper.selectByKey(loginname);
        if(user!=null){
            if (user.getPasswd().equals(passwd)){

                String jwtToken=jwtUtils.generateToken(String.valueOf(user.getId()));
                response.setHeader(HttpUtils.Authorization,jwtToken);
                response.setHeader(HttpUtils.Access_Control_Expose_Headers,HttpUtils.Authorization);

            return Result.success(user);
            } else{
                throw new UnknownAccountException("账户或者密码不正确");
            }
        }else {
            throw new UnknownAccountException("账户或者密码不正确");
        }
//        return super.selectByJsonString(object);
    }

    @Override
    public Result selectByIdFromOne(int id) {
        CmsUser user = cmsUserMapper.selectByPrimaryKey(id);
        if(user!=null){
            return Result.success(user);
        }else
        {
            return Result.fail(ResultCode.UNKNOWERROR,"error");
        }

//        return super.selectByIdFromOne(id);
    }

    @Override
    public Result selectByAllList(JSONObject object) {
        log.info(object.toJSONString());
        String start=object.getString("start");
        String count=object.getString("count");//也是end
        PageHelper.startPage(Integer.valueOf(start),Integer.valueOf(count));
        try {
        PageInfo pageInfo=new PageInfo(cmsUserMapper.selectByAll());
            return Result.success(pageInfo);
        }catch (Exception e){
           return Result.fail(ResultCode.UNKNOWERROR,e.getMessage());
        }
    }

    @Override
    public Result updateByJsonString(JSONObject object) {


        return super.updateByJsonString(object);
    }



    @Override
    public Result insertByJsonString(JSONObject object) {


        return super.insertByJsonString(object);
    }

}
