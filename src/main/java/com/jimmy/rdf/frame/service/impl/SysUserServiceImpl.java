package com.jimmy.rdf.frame.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.jimmy.rdf.frame.entity.SysUser;
import com.jimmy.rdf.frame.mapper.SysResourcesMapper;
import com.jimmy.rdf.frame.mapper.SysUserMapper;
import com.jimmy.rdf.frame.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @version: V1.0
 * @author: Zhongyuan Wang
 * @className: SysUserServiceImpl
 * @description:  UserService接口实现
 * @data: 2018-08-17 07:39
 **/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
	@Autowired
	private SysResourcesMapper sysResourcesMapper;
	@Override
	public boolean deleteAll() {
		return retBool(baseMapper.deleteAll());
	}

	@Override
	public List<SysUser> selectListBySQL() {
		return baseMapper.selectListBySQL();
	}

	@Override
	public List<SysUser> selectListByWrapper(Wrapper wrapper) {
		return baseMapper.selectListByWrapper(wrapper);
	}

	@Override
	public SysUser getUser(Long id) {
		return baseMapper.selectById(id);
	}

	@Override
	public void deleteUser(Long id) {
		baseMapper.deleteById(id);
	}

	@Override
	public SysUser selectByUsername(SysUser sysUser) {

		return baseMapper.selectOne(new QueryWrapper<SysUser>(sysUser));
	}

	@Override
	public Set<String> findPermissionsByUserId(Long userId) {
		Set<String> permissions = sysResourcesMapper.findRoleNameByUserId(userId);
		Set<String> result = new HashSet<>();
		for (String permission : permissions) {
			if (StringUtils.isBlank(permission)) {
				continue;
			}
			permission = StringUtils.trim(permission);
			result.addAll(Arrays.asList(permission.split("\\s*;\\s*")));
		}
		return result;
	}


}