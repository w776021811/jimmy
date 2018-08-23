package com.jimmy.rdf.frame.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.jimmy.rdf.frame.entity.SysResources;
import com.jimmy.rdf.frame.mapper.SysResourcesMapper;
import com.jimmy.rdf.frame.service.SysResourcesService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service("sysResourcesService")
public class SysResourcesServiceImpl extends ServiceImpl<SysResourcesMapper,SysResources> implements SysResourcesService {

    @Override
    public List<SysResources> listAll() {
        return baseMapper.selectAll();
    }

    @Override
    @Cacheable(cacheNames="resources",key="#map['userid'].toString()+#map['type']")
    public List<SysResources> loadUserResources(Map<String, Object> map) {
        List<SysResources> list=baseMapper.loadUserResources(map);
        return list;
    }


    public List<SysResources> queryResourcesByParentId(Map<String, Object> map) {
        return baseMapper.queryResourcesByParentId(map);
    }
}
