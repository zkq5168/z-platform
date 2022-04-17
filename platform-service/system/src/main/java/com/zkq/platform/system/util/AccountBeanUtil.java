package com.zkq.platform.system.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zkq.platform.system.entity.dto.AccountDTO;
import com.zkq.platform.system.entity.po.TAccount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountBeanUtil {
    AccountBeanUtil INSTANCE = Mappers.getMapper(AccountBeanUtil.class);

    AccountDTO poToDto(TAccount source);

    TAccount dtoToPo(AccountDTO source);

    List<AccountDTO> listPoToDto(List<TAccount> source);

    Page<AccountDTO> pagePoToDto(Page<TAccount> source);
}
