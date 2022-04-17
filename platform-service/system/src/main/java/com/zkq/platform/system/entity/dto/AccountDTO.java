package com.zkq.platform.system.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户账户表
 * @author zkq
 */
@Data
public class AccountDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private String id;
    /**
     * 账户ID
     */
    private String accountId;

    /**
     * 账户名称
     */
    private String accountName;

    /**
     * 密码
     */
    private String password;

    /**
     * 所属单位
     */
    private String companyId;
}