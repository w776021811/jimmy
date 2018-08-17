package com.jimmy.frame.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @version: V1.0
 * @author: Zhongyuan Wang
 * @className: SuperEntity
 * @description:  父实体
 * @data: 2018-08-17 07:15
 **/
public class SuperEntity<T extends Model> extends Model<T> {

    /**
     * 主键ID , 这里故意演示注解可以无
     */
    @TableId("id")
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("租户")
    private Long tenantId;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_date",fill = FieldFill.INSERT)
    private Date createDate;

    @ApiModelProperty("更新时间")
    @TableField(value = "update_date",fill = FieldFill.INSERT_UPDATE)
    private Date updateDate;

    @ApiModelProperty("创建人")
    private Long createUser;

    @ApiModelProperty("更新人")
    private Long updateUser;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public SuperEntity setTenantId(Long tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
