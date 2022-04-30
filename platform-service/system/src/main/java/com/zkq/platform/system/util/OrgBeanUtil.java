package com.zkq.platform.system.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zkq.platform.system.entity.dto.OrgDTO;
import com.zkq.platform.system.entity.po.TOrg;
import com.zkq.platform.system.entity.vo.OrgVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
/**
 * 组织表MapStruct生成工具类
 * @author t_org
 * @date 2022-04-20
 */
@Mapper(componentModel = "spring")
public interface OrgBeanUtil {
    OrgBeanUtil INSTANCE = Mappers.getMapper(OrgBeanUtil.class);

    TOrg dtoToPo(OrgDTO source);

    OrgDTO poToDto(TOrg source);

    List<OrgDTO> listPoToDto(List<TOrg> source);

    Page<OrgDTO> pagePoToDto(Page<TOrg> source);

    List<OrgVO> listDtoToVo(List<OrgDTO> orgDTOList);
}
