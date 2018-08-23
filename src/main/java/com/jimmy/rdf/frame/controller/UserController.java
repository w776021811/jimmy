package com.jimmy.rdf.frame.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiAssert;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.ApiResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jimmy.rdf.frame.entity.SysUser;
import com.jimmy.rdf.frame.service.SysUserService;
import com.jimmy.rdf.frame.utils.ResultData;
import com.jimmy.rdf.frame.utils.SimpleCode;
import com.jimmy.rdf.frame.utils.SimpleError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.WatchEvent;

@RestController
@RequestMapping("/user")
public class UserController extends ApiController {

    @Autowired
    private SysUserService userService;


    @GetMapping("/test")
    public ApiResult<String> testError(String test) {
        ApiAssert.notNull(SimpleError.BPERROR, test);
        return success(test);
    }

    /**
     * http://localhost:8080/user/test
     */
    @GetMapping("/test1")
    @Cacheable("test1")
    public ResultData<IPage<SysUser>> test() {
        IPage <SysUser> sysUserIPage = userService.page(new Page<SysUser>(0, 2), null);
        return new ResultData<IPage <SysUser>>(SimpleCode.BPSUCCESS, sysUserIPage);
    }

    @GetMapping("/test2")
    public boolean test2() {
        return userService.removeById(1L);
    }

    @GetMapping("/test3")
    public Object getUserByWrapper() {
        Wrapper<SysUser> wrapper = new QueryWrapper<SysUser>().lambda().like(SysUser::getName,"王");
        return userService.selectListByWrapper(wrapper);
    }
}
