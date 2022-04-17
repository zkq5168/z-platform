package com.zkq.platform.system.entity.dto;

import lombok.Data;

/**
 * 登录用户
 * @author zkq
 * @date 2022-04-10
 */
@Data
public class LoginUser {
    private String accountId;
    private String password;
}
