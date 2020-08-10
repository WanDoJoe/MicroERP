package com.wdqsoft.system.services.impl;

import com.wdqsoft.system.services.interf.ShiroAccountUserServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ShiroAccountUserServicesimpl  {

//    @Autowired
//    CMSUserService userService;
//    @Autowired
//    TCmsRoleMapper roleMapper;
//    @Override
//    public AccountProfile accountUser(String oid) {
//        AccountProfile accountProfile;
//        if(oid.split("-").length>0){
//            new Throwable("系统错误！");
//        }
//        if(oid.split("-")[0].equals("cms") ){
//            accountProfile=new AccountProfile();
//           TCmsManageuser tCmsManageuser=
//                   userService.selectById(Integer.valueOf(oid.split("-")[1]));
//            TCmsRole tCmsRole=roleMapper.selectByPrimaryKey(tCmsManageuser.getRoleid());
//            accountProfile.setId(String.valueOf(tCmsManageuser.getId()));
//            accountProfile.setName(tCmsManageuser.getName());
//            accountProfile.setLoginname(tCmsManageuser.getLoginname());
////            accountProfile.setRole("["+tCmsRole.getRolename()+"]");
//            accountProfile.setRole(tCmsRole.getRolename());
//            accountProfile.setIsavailable(tCmsManageuser.getIsavailable());
//        }else{
//            accountProfile=new AccountProfile();
//            accountProfile.setId(oid.split("-")[1]);
//            accountProfile.setName(oid.split("-")[2]);
//            accountProfile.setLoginname(oid.split("-")[3]);
//            accountProfile.setRole("user");
//            accountProfile.setIsavailable(1);
//        }
//        return accountProfile;
//    }
}
