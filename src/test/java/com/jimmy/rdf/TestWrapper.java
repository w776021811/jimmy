package com.jimmy.rdf;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jimmy.rdf.frame.entity.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Component
public class TestWrapper {
    @Test
    public void testTSQL11() {
    /*
     * 实体带查询使用方法  输出看结果
     */
        Wrapper<SysUser> ew = new QueryWrapper<SysUser>().lambda().like(SysUser::getName,"b");

        System.out.println(ew.getSqlSegment());
    }
}
