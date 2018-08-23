package com.jimmy.rdf.frame.mapper;


import com.jimmy.rdf.frame.entity.SysResources;
import com.jimmy.rdf.frame.persistent.SuperMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @version: V1.0
 * @author: Zhongyuan Wang
 * @className: SysResourcesMapper
 * @description:  Resources 表数据库控制层接口
 * @data: 2018-08-20 22:37
 **/
public interface SysResourcesMapper extends SuperMapper<SysResources> {


      @Select("SELECT sre.res_url FROM sys_user_role sur LEFT JOIN sys_user su ON su.id = sur.user_id \n" +
              "LEFT JOIN sys_role sr ON sur.role_id=sr.id LEFT JOIN sys_role_resources srr ON sur.role_id = srr.role_id\n" +
              "LEFT JOIN sys_resources sre ON sre.id = srr.resources_id\n" +
              "WHERE su.id=#{userId}")
      Set<String> findRoleNameByUserId(@Param("userId") Long userId);

      @Select("select id,res_name,res_type,res_url,parent_id,available,res_sort,tenant_id,is_enable,create_date,create_user,update_date,update_user from sys_resources ")
      List<SysResources> selectAll();

      List<SysResources> loadUserResources(Map<String, Object> map);

      List<SysResources> queryResourcesByParentId(Map<String, Object> map);
}
