package com.jimmy.rdf.frame.mapper;


import com.jimmy.rdf.frame.entity.SysRole;
import com.jimmy.rdf.frame.persistent.SuperMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 /**
 * @version: V1.0
 * @author: Zhongyuan Wang
 * @className: SysRoleMapper
 * @description:  Role 表数据库控制层接口
 * @data: 2018-08-20 22:37
 **/
public interface SysRoleMapper extends SuperMapper<SysRole> {

    @Select("SELECT sr.role_desc FROM sys_user_role sur LEFT JOIN sys_role sr ON sr.id = sur.role_id \n" +
            "LEFT JOIN sys_user su ON sur.user_id = su.id WHERE su.id = #{userId}")
    Set<String> findRoleNameByUserId(@Param("userId") Long userId);
}
