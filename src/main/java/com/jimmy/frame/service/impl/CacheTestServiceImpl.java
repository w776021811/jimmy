package com.jimmy.frame.service.impl;

import com.jimmy.frame.service.CacheTestService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("cacheTestService")
public class CacheTestServiceImpl implements CacheTestService {
    final static Log log = LogFactory.getLog(CacheTestService.class);
    @Override
    @Cacheable(value = "getData")
    public String getData() {
        System.out.println("=====看见这句话，表示你没有读取缓存数据====");
        return "当前系统时间搓" + System.currentTimeMillis();
    }
}
