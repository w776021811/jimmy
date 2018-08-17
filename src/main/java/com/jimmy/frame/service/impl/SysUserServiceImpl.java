package com.jimmy.frame.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jimmy.frame.entity.SysUser;
import com.jimmy.frame.mapper.SysUserMapper;
import com.jimmy.frame.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version: V1.0
 * @author: Zhongyuan Wang
 * @className: SysUserServiceImpl
 * @description:  UserService接口实现
 * @data: 2018-08-17 07:39
 **/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

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
}