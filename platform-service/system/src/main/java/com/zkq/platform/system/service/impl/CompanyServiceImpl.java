package com.zkq.platform.system.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zkq.platform.system.entity.dto.CompanyDTO;
import com.zkq.platform.system.entity.po.TCompany;
import com.zkq.platform.system.mapper.CompanyMapper;
import com.zkq.platform.system.service.ICompanyService;
import com.zkq.platform.system.util.CompanyBeanUtil;
import com.zkq.platform.webcommon.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl extends BaseServiceImpl<CompanyMapper, TCompany, CompanyDTO> implements ICompanyService {
    @Override
    public TCompany generateUUID(TCompany tCompany) {
        tCompany.setCompanyId(IdUtil.simpleUUID());
        return tCompany;
    }

    @Override
    public TCompany dtoToPo(CompanyDTO companyDTO) {
        return CompanyBeanUtil.INSTANCE.dtoToPo(companyDTO);
    }

    @Override
    public CompanyDTO poToDto(TCompany entity) {
        return CompanyBeanUtil.INSTANCE.poToDto(entity);
    }
    @Override
    public List<CompanyDTO> listPoToDto(List<TCompany> source) {
        return CompanyBeanUtil.INSTANCE.listPoToDto(source);
    }
    @Override
    public Page<CompanyDTO> pagePoToDto(Page<TCompany> source) {
        return CompanyBeanUtil.INSTANCE.pagePoToDto(source);
    }
}
