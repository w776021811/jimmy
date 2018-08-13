package com.jimmy.frame.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.jimmy.frame.persistent.SuperMapper;
import com.jimmy.frame.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * User 表数据库控制层接口
 */
public interface SysUserMapper extends SuperMapper<SysUser> {

    /**
     * 自定义注入方法
     */
    int deleteAll();

    @Select("select id , name, username, password, salt, state from sys_user")
    List<SysUser> selectListBySQL();

    List<SysUser> selectListByWrapper(@Param("ew") Wrapper wrapper);

}