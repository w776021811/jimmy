package com.jimmy.rdf.frame.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jimmy.rdf.frame.entity.enums.AvailableEnum;
import com.jimmy.rdf.frame.entity.enums.IsEnableEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@TableName("sys_resources")
@ApiModel(value="Resources对象",description="菜单资源信息")
public class SysResources extends SuperEntity<SysResources> implements Serializable{


    @ApiModelProperty(value = "资源名称",name="userName",example="系统管理")
    private String resName;

    @ApiModelProperty(value = "资源URL",name="resUrl",example="系统管理")
    private String resUrl;

    @ApiModelProperty(value = "资源类型",name="resType",example="0：菜单 1：按钮 ")
    private Integer resType;

    @ApiModelProperty(value = "父资源ID",name="parentId",example="1")
    private Integer parentId;

    @ApiModelProperty(value = "资源排序",name="resSort",example="1")
    private Integer resSort;
    @ApiModelProperty(value = "是否可用",name="available",example="1")
    private AvailableEnum available;
    /**
     * 删除标记
     */
    @TableField(value = "IS_ENABLE", fill = FieldFill.INSERT)
    @TableLogic(value = "1")
    @ApiModelProperty(hidden = true)
    private IsEnableEnum isEnable;

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    public Integer getResType() {
        return resType;
    }

    public void setResType(Integer resType) {
        this.resType = resType;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getResSort() {
        return resSort;
    }

    public void setResSort(Integer resSort) {
        this.resSort = resSort;
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
        return "SysResources{" +
                "resName='" + resName + '\'' +
                ", resUrl='" + resUrl + '\'' +
                ", resType=" + resType +
                ", parentId=" + parentId +
                ", resSort=" + resSort +
                ", available=" + available +
                ", isEnable=" + isEnable +
                '}';
    }
}