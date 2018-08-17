package com.jimmy;

import com.jimmy.frame.entity.SysUser;
import com.jimmy.frame.service.SuperRedisService;
import com.jimmy.frame.service.CacheTestService;
import com.jimmy.frame.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@Component
public class JimmyApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private CacheTestService cacheTestService;
	@Autowired
	private SuperRedisService rs;
	@Autowired
	private SysUserService userService;


	@Test
	public void set(){
		redisTemplate.opsForValue().set("test:set","testValue2");
	}



	@Test
	public void cacheTest() {
		for (int i=0;i<5;i++){
			System.out.println(cacheTestService.getData());
			try{
				Thread.sleep(1000);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}

	@Test
	public void getUser() {
		for (int i = 0; i < 10; i++) {
			SysUser user = userService.getUser(Long.valueOf(i));
			System.out.println(user);
		}
	}

	@Test
	public void RedisTest() throws Exception {
		rs.set("test1", "11");
		System.out.println(rs.get("test1"));
		System.out.println(rs.get("test:set"));
		System.out.println(cacheTestService.getData());
	}
}
