package com.wdqsoft.system.database.cms.mybatis.cmsh2db;

import com.wdqsoft.system.database.cms.bean.CmsRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface CmsRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CmsRole record);

    int insertSelective(CmsRole record);

    CmsRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CmsRole record);

    int updateByPrimaryKey(CmsRole record);
}