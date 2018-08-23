package com.jimmy.rdf.frame.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jimmy.rdf.frame.entity.enums.AvailableEnum;
import com.jimmy.rdf.frame.entity.enums.IsEnableEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@TableName("sys_role")
@ApiModel(value="Role对象",description="角色信息")
public class SysRole extends SuperEntity<SysRole> implements Serializable {

    @ApiModelProperty(value = "角色名称",name="roleDesc",example="超级管理员")
    private String roleDesc;
    @ApiModelProperty(value = "是否启用",name="available",example="1")
    private AvailableEnum available;
    /**
     * 删除标记
     */
    @TableField(value = "IS_ENABLE", fill = FieldFill.INSERT)
    @TableLogic(value = "1")
    @ApiModelProperty(hidden = true)
    private IsEnableEnum isEnable;

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public AvailableEnum getAvailable() {
        return available;
    }

    public void setAvailable(AvailableEnum available) {
        this.available = available;
    }

    public IsEnableEnum getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(IsEnableEnum isEnable) {
        this.isEnable = isEnable;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "roleDesc='" + roleDesc + '\'' +
                ", available=" + available +
                ", isEnable=" + isEnable +
                '}';
    }
}