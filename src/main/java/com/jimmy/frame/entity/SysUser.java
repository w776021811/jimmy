package com.jimmy.frame.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jimmy.frame.entity.enums.IsEnableEnum;
import com.jimmy.frame.entity.enums.StateEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户表
 */
@TableName("sys_user")
@ApiModel(value="User对象",description="用户信息")
public class SysUser extends SuperEntity<SysUser> {

    @ApiModelProperty(value = "姓名",name="name",example="王忠元")
    private String name;

    @ApiModelProperty(value = "登陆号",name="username",example="admin")
    @TableField(value = "username",fill = FieldFill.INSERT)
    private String username;

    @ApiModelProperty(value = "密码",name="password",example="MD5(password+salt)")
    private String password;

    @ApiModelProperty(value = "密码盐",name="salt",example="admin")
    private  String salt;

    /**
     * 账号状态 1正常 2冻结
     */
    @ApiModelProperty(value = "账号状态",name="state",example="1",required=true)
    private StateEnum state;
    /**
     * 删除标记
     */
    @TableField(value = "IS_ENABLE", fill = FieldFill.INSERT)
    @TableLogic(value = "1")
    @ApiModelProperty(hidden = true)
    private IsEnableEnum isEnable;

    public SysUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public StateEnum getState() {
        return state;
    }

    public IsEnableEnum getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(IsEnableEnum isEnable) {
        this.isEnable = isEnable;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }
    public SysUser(Long id, String name, String username, String password, String salt, StateEnum state,IsEnableEnum isEnable) {
        this.setId(id);
        this.name = name;
        this.username = username;
        this.password = password;
        this.salt=salt;
        this.state=state;
        this.isEnable=isEnable;
    }
    public SysUser(String name, String username, String password, String salt, StateEnum state,IsEnableEnum isEnable) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.salt=salt;
        this.state=state;
        this.isEnable=isEnable;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", state=" + state +
                ", isEnable=" + isEnable +
                '}';
    }
}
