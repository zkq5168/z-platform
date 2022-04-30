package com.zkq.platform.system.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 组织表
 * @author zkq
 * @date 2022-04-20
 */
@Data
public class OrgVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * 组织ID
     */
    private String orgId;
    
    /**
     * 组织名称
     */
    private String orgName;
    
    /**
     * 组织简称
     */
    private String orgShortName;
    
    /**
     * 组织类型
     */
    private String orgType;
    
    /**
     * 上级组织ID
     */
    private String parentOrgId;
    
    /**
     * 显示排序
     */
    private Integer displayOrder;
    
    /**
     * 是否启用
     */
    private String enable;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 创建人
     */
    private String creater;
    
    /**
     * 更新时间
     */
    private Date updateTime;
    
    /**
     * 更新人
     */
    private String updater;
    
    /**
     * 删除标志
     */
    private String deleteFlag;
    
    /**
     * 删除时间
     */
    private Date deleteTime;
    
}