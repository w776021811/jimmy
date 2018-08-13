package com.jimmy.frame.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jimmy.frame.entity.SysUser;

import java.util.List;

/**
 *
 * User 表数据服务层接口
 *
 */
public interface ISysUserService extends IService<SysUser> {

	boolean deleteAll();

	public List<SysUser> selectListBySQL();

	public List<SysUser> selectListByWrapper(Wrapper wrapper);
}