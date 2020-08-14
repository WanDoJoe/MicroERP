package com.wdqsoft.system.database.cms.mybatis.cmsh2db;

import com.wdqsoft.system.database.cms.bean.CmsUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CmsUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CmsUser record);

    int insertSelective(CmsUser record);

    CmsUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CmsUser record);

    int updateByPrimaryKey(CmsUser record);

    CmsUser selectByKey(@Param("key") String key);
    List<CmsUser> selectByPageinfo();
    List<CmsUser> selectByAll();
    List<CmsUser> selectBylimt(@Param("start")int start,@Param("end")int end);
}