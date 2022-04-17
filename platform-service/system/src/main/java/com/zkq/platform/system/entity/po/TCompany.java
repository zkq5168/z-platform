package com.zkq.platform.system.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 单位信息表
 * @author zkq
 */
@Data
@TableName("t_company")
public class TCompany implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 单位ID
     */
    @TableId("company_id")
    private String companyId;

    /**
     * 单位编码
     */
    @TableField("company_code")
    private String companyCode;

    /**
     * 单位名称
     */
    @TableField("company_name")
    private String companyName;

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
     * 删除标志（0：未删除，1：已删除）
     */
    @TableField("delete_flag")
    private String deleteFlag;
}