package com.jimmy.frame.entity.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum IsEnableEnum implements IEnum<Integer> {

    ENABLE(1,"是"),
    LIMIT(0,"否");
    private Integer value;
    private String desc;

    IsEnableEnum(final Integer value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    public String getDesc(){
        return this.desc;
    }
}
