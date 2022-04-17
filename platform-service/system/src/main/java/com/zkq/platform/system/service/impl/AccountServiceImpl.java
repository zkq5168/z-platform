package com.zkq.platform.system.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zkq.platform.system.entity.dto.AccountDTO;
import com.zkq.platform.system.entity.po.TAccount;
import com.zkq.platform.system.mapper.AccountMapper;
import com.zkq.platform.system.service.IAccountService;
import com.zkq.platform.system.util.AccountBeanUtil;
import com.zkq.platform.webcommon.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl extends BaseServiceImpl<AccountMapper, TAccount, AccountDTO> implements IAccountService {
    @Override
    public TAccount generateUUID(TAccount tAccount) {
        tAccount.setId(IdUtil.simpleUUID());
        return tAccount;
    }

    @Override
    public TAccount dtoToPo(AccountDTO accountDTO) {
        return AccountBeanUtil.INSTANCE.dtoToPo(accountDTO);
    }

    @Override
    public AccountDTO poToDto(TAccount entity) {
        return AccountBeanUtil.INSTANCE.poToDto(entity);
    }
    @Override
    public List<AccountDTO> listPoToDto(List<TAccount> source) {
        return AccountBeanUtil.INSTANCE.listPoToDto(source);
    }
    @Override
    public Page<AccountDTO> pagePoToDto(Page<TAccount> source) {
        return AccountBeanUtil.INSTANCE.pagePoToDto(source);
    }
}
