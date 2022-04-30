package com.zkq.platform.system.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 组织表
 * @author t_org
 */
@Data
@TableName("t_org")
public class TOrg implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 组织ID
     */
     @TableId("org_id")
     private String orgId;
    
    /**
     * 组织名称
     */
     @TableField("org_name")
     private String orgName;
    
    /**
     * 组织简称
     */
     @TableField("org_short_name")
     private String orgShortName;
    
    /**
     * 组织类型
     */
     @TableField("org_type")
     private String orgType;
    
    /**
     * 上级组织ID
     */
     @TableField("parent_org_id")
     private String parentOrgId;
    
    /**
     * 显示排序
     */
     @TableField("display_order")
     private Integer displayOrder;
    
    /**
     * 是否启用
     */
     @TableField("enable")
     private String enable;
    
    /**
     * 创建时间
     */
     @TableField("create_time")
     private Date createTime;
    
    /**
     * 创建人
     */
     @TableField("creater")
     private String creater;
    
    /**
     * 更新时间
     */
     @TableField("update_time")
     private Date updateTime;
    
    /**
     * 更新人
     */
     @TableField("updater")
     private String updater;
    
    /**
     * 删除标志
     */
     @TableField("delete_flag")
     private String deleteFlag;
    
    /**
     * 删除时间
     */
     @TableField("delete_time")
     private Date deleteTime;
    
}