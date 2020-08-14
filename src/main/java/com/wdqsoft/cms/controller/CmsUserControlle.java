package com.wdqsoft.cms.controller;

import com.alibaba.fastjson.JSONObject;
import com.wdqsoft.system.common.lang.Result;
import com.wdqsoft.system.services.impl.CmsUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/cms/v1/user")
public class CmsUserControlle {

    @Autowired
    CmsUserService cmsUserService;




    @RequestMapping(value = "/list/{start}/{count}")
    public Result getUser(@PathVariable(value = "start") int start,@PathVariable(value = "count") int count){

        JSONObject object=new JSONObject();
        object.put("start",start);
        object.put("count",count);

        return cmsUserService.selectByAllList(object);
    }
}
