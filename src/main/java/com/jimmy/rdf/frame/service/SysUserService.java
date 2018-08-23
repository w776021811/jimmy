package com.jimmy.rdf.frame.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jimmy.rdf.frame.entity.SysUser;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Set;


/**
 * @version: V1.0
 * @author: Zhongyuan Wang
 * @className: SysUserService
 * @description:  User 表数据服务层接口
 * @data: 2018-08-17 07:38
 **/
public interface SysUserService extends IService<SysUser> {

	boolean deleteAll();

	 List<SysUser> selectListBySQL();

	 List<SysUser> selectListByWrapper(Wrapper wrapper);

	@Cacheable("user_"+"#id")
	SysUser getUser(Long id);

	@CacheEvict("'user_'+#id")
	void deleteUser(Long id);

	SysUser selectByUsername(SysUser sysUser);

	/**
	 * 获取用户权限
	 *
	 * @param userId userId
	 * @return 用户权限
	 */
	Set<String> findPermissionsByUserId(Long userId);
}