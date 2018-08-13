package com.jimmy.frame.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jimmy.frame.entity.SysUser;
import com.jimmy.frame.mapper.SysUserMapper;
import com.jimmy.frame.service.ISysUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * User 表数据服务层接口实现类
 *
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

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
}