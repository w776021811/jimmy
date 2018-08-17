package com.jimmy.frame.persistent;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;


/**
 * @version: V1.0
 * @author: Zhongyuan Wang
 * @className: SuperMapper
 * @description:  mapper 父类，注意这个类不要让 mp 扫描到！！
 * @data: 2018-08-17 07:37
 **/
public interface SuperMapper<T> extends BaseMapper<T> {

    // 这里可以放一些公共的方法
}
