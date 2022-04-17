package com.zkq.platform.system.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户账户表
 * @author zkq
 */
@TableName("t_account")
@Data
public class TAccount implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("id")
    private String id;

    /**
     * 账户ID
     */
    @TableField("account_id")
    private String accountId;

    /**
     * 账户名称
     */
    @TableField("account_name")
    private String accountName;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 所属单位
     */
    @TableField("companyId")
    private String companyId;
}