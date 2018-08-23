package com.jimmy.rdf.frame.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jimmy.rdf.frame.entity.SysRole;

import java.util.Set;

/**
 * @version: V1.0
 * @author: Zhongyuan Wang
 * @className: SysRoleService
 * @description: Role服务层接口
 * @data 2018/8/21 9:10
 **/
public interface SysRoleService extends IService<SysRole>{
    Set<String> findRoleNameByUserId(Long userId);
}
