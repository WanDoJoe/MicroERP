package com.wdqsoft.cms.controller;

import com.alibaba.fastjson.JSONObject;
import com.wdqsoft.system.common.lang.Result;
import com.wdqsoft.system.services.impl.CmsUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("/cms/v1/login")
public class CmsLoginConrtoller {

    @Autowired
    CmsUserService cmsUserService;

    @RequestMapping(value = "/l/{loginname}/{passwd}")
    public Result Login(HttpServletResponse response,@PathVariable(value = "loginname") String loginname, @PathVariable(value = "passwd") String passwd){
        JSONObject object=new JSONObject();

        object.put("loginname",loginname);
        object.put("passwd",passwd);

        return  cmsUserService.Login(object,response);
    }
}
