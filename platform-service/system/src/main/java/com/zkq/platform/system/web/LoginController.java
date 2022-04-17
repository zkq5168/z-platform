package com.zkq.platform.system.web;

import com.zkq.platform.system.entity.dto.AccountDTO;
import com.zkq.platform.system.entity.dto.LoginUser;
import com.zkq.platform.system.entity.po.TAccount;
import com.zkq.platform.system.util.AccountBeanUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * 登录控制器
 * @author zkq
 * @date 2022-04-10
 */
@RestController
@RequestMapping("/")
public class LoginController {


    /**
     * 登录
     * @param loginUser
     * @param response
     * @return
     */
    @PostMapping("/login")
    public LoginUser login(@RequestBody LoginUser loginUser, HttpServletResponse response){
        String accountId = loginUser.getAccountId();
        AccountDTO dto = new AccountDTO();
        dto.setAccountId(accountId);
        TAccount account = AccountBeanUtil.INSTANCE.dtoToPo(dto);
        return loginUser;
    }

    /**
     * 注销
     * @return
     */
    @GetMapping("/logout")
    public boolean logout(){
        return true;
    }
}
