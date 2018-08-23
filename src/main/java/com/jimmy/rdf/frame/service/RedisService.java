package com.jimmy.rdf.frame.service;

import org.springframework.data.redis.core.BoundSetOperations;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface RedisService<T> {
    /**
     * 将 key，value 存放到redis数据库中，默认设置过期时间为一天
     *
     * @param key
     * @param value
     */
    void set(String key, T value);
    /**
     * 将 key，value 存放到redis数据库中，设置过期时间单位是分钟
     *
     * @param key
     * @param value
     * @param expireTime 单位是秒
     */
    void set(String key, T value, long expireTime);
    /**
     * 判断 key 是否在 redis 数据库中
     *
     * @param key
     * @return
     */
    boolean exists(final String key);
    /**
     * 获取 key 对应的字符串
     * @param key
     * @return
     */
    T get(String key);
    /**
     * 获得 key 对应的键值，并更新缓存时间，时间长度为默认值
     * @param key
     * @return
     */
    T getAndUpdateTime(String key);

    /**
     * 删除 key 对应的 value
     * @param key
     */
    void delete(String key);
}
