package com.jimmy.rdf;

import com.jimmy.rdf.frame.entity.SysUser;
import com.jimmy.rdf.frame.service.RedisService;
import com.jimmy.rdf.frame.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Component
public class TestRedis {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate template;
    @Autowired
    private RedisService<Object> redisService;
    @Autowired
    private SysUserService userService;

    @Test
    public void set(){
        redisTemplate.opsForValue().set("test:set","testValue1");
    }

    @Test
    public void getUser() {
     //   for (int i = 0; i < 10; i++) {
            SysUser user = userService.getUser(((long)1));
            System.out.println(user);
            redisService.set("redisServiceTest",user);
            Object redisServiceTest = redisService.get("redisServiceTest");
            System.out.println(redisServiceTest);
     //   }
    }

}
