package com.zkq.platform.system.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zkq.platform.system.entity.dto.CompanyDTO;
import com.zkq.platform.system.entity.po.TCompany;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyBeanUtil {
    CompanyBeanUtil INSTANCE = Mappers.getMapper(CompanyBeanUtil.class);

    TCompany dtoToPo(CompanyDTO companyDTO);

    CompanyDTO poToDto(TCompany entity);

    List<CompanyDTO> listPoToDto(List<TCompany> source);

    Page<CompanyDTO> pagePoToDto(Page<TCompany> source);
}
