package com.zkq.platform.system.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 单位信息表
 * @author zkq
 */
@Data
public class CompanyVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 单位ID
     */
    private String companyId;

    /**
     * 单位编码
     */
    private String companyCode;

    /**
     * 单位名称
     */
    private String companyName;

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
     * 删除标志（0：未删除，1：已删除）
     */
    private String deleteFlag;
}