package com.jimmy.frame.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jimmy.frame.entity.SysUser;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;


/**
 * @version: V1.0
 * @author: Zhongyuan Wang
 * @className: SysUserService
 * @description:  User 表数据服务层接口
 * @data: 2018-08-17 07:38
 **/
public interface SysUserService extends IService<SysUser> {

	boolean deleteAll();

	public List<SysUser> selectListBySQL();

	public List<SysUser> selectListByWrapper(Wrapper wrapper);

	@Cacheable(key="'user_'+#id",value="'user'+#id")
	SysUser getUser(Long id);

	@CacheEvict(key="'user_'+#id", value="users", condition="#id!=1")
	void deleteUser(Long id);
}