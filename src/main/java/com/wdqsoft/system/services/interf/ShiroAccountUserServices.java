package com.wdqsoft.system.services.interf;


import com.wdqsoft.system.shiro.AccountProfile;

public interface ShiroAccountUserServices extends BaseService{
    public AccountProfile accountUser(String oid);

}
