package com.jimmy.rdf.frame.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@TableName("sys_role_resources")
@ApiModel(value="RoleResources对象",description="角色资源绑定信息")
public class SysRoleResources extends SuperEntity<SysRoleResources> implements Serializable{

    @ApiModelProperty(value = "角色ID",name="roleId",example="1")
    private Integer roleId;
    @ApiModelProperty(value = "资源ID",name = "resourcesId",example = "1")
    private Integer resourcesId;

    public Integer getRoleId() {
        return roleId;
    }


    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }


    public Integer getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(Integer resourcesId) {
        this.resourcesId = resourcesId;
    }

    @Override
    public String toString() {
        return "SysRoleResources{" +
                "roleId=" + roleId +
                ", resourcesId=" + resourcesId +
                '}';
    }
}