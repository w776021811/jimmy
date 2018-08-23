package com.jimmy.rdf.frame.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.jimmy.rdf.frame.entity.SysRole;
import com.jimmy.rdf.frame.mapper.SysRoleMapper;
import com.jimmy.rdf.frame.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("sysRoleServiceImpl")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper,SysRole> implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Override
    public Set<String> findRoleNameByUserId(Long userId) {
        return sysRoleMapper.findRoleNameByUserId(userId);
    }
}
