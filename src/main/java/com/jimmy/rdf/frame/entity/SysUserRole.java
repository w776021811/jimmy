package com.jimmy.rdf.frame.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@TableName("sys_user_role")
@ApiModel(value = "UserRole对象",description = "用户角色绑定信息表")
public class SysUserRole extends SuperEntity <SysUserRole>  implements Serializable{

    @ApiModelProperty(value = "用户ID",name = "userID",example = "1")
    private Integer userId;

    @ApiModelProperty(value = "角色ID",name = "roleId",example = "1")
    private Integer roleId;

    public Integer getUserId() {
        return userId;
    }


    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Integer getRoleId() {
        return roleId;
    }


    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "SysUserRole{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}