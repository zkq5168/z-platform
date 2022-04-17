package com.zkq.platform.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zkq.platform.system.entity.po.TAccount;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper extends BaseMapper<TAccount> {

}