package com.jimmy.rdf.frame.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jimmy.rdf.frame.entity.SysResources;

import java.util.List;
import java.util.Map;

/**
 * @version: V1.0
 * @author: Zhongyuan Wang
 * @className: SysResourcesService
 * @description:
 * @data 2018/8/23 1:13
 **/
public interface SysResourcesService extends IService<SysResources> {

    List<SysResources> listAll();

    List<SysResources> loadUserResources(Map<String,Object> map);

    List<SysResources> queryResourcesByParentId(Map<String, Object> map);
}
