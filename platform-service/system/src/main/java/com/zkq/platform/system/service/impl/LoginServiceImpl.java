package com.zkq.platform.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zkq.platform.system.entity.po.TAccount;
import com.zkq.platform.system.mapper.AccountMapper;
import com.zkq.platform.system.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl extends ServiceImpl<AccountMapper, TAccount> implements ILoginService {
    @Autowired
    private AccountMapper accountMapper;
}
