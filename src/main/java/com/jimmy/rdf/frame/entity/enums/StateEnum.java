package com.jimmy.rdf.frame.entity.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StateEnum implements IEnum<Integer> {
    NORMAL(1,"正常"),
    FROZEN(2,"冻结");
    private Integer value;
    private String desc;

    StateEnum(final Integer value, final String desc) {
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
