package com.jimmy.frame.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * @version: V1.0
 * @author: Zhongyuan Wang
 * @className: MetaObjectHandlerConfig
 * @description:  MetaObjectHandlerConfig配置文件
 * @data: 2018-08-17 07:14
 **/
@Component
public class MetaObjectHandlerConfig implements MetaObjectHandler {

  @Override
  public void insertFill(MetaObject metaObject) {
    Object createDate = metaObject.getValue("createDate");
    if (null == createDate) {
      metaObject.setValue("isEnable", "1");
      metaObject.setValue("createDate", new Date());
      metaObject.setValue("updateDate", new Date());
   //   metaObject.setValue("createUser",1L);
   //   metaObject.setValue("updateUser", 1L);
    }
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    Object createDate = metaObject.getValue("updateDate");
    if (null == createDate) {
    //  metaObject.setValue("updateDate", new Date());
   //   metaObject.setValue("updateUser", 1L);
    }
  }
}
