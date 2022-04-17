package com.zkq.platform.webcommon.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zkq.platform.webcommon.entity.dto.PageQueryDTO;

import java.util.List;
import java.util.function.Function;

/**
 * 业务逻辑基础接口
 * @param <T>
 */
public interface IBaseService<T, DTO> extends IService<T> {
    DTO saveEntity(DTO dto);
    int deleteById(String id);
    int deleteByIds(List<String> ids);
    DTO update(DTO dto);
    DTO getById(String id);
    List<DTO> list(DTO dto);
    List<DTO> list(DTO dto, Function<DTO, LambdaQueryWrapper<T>> func);
    Page<DTO> page(PageQueryDTO<DTO> pageQueryDTO);
    Page<DTO> page(PageQueryDTO<DTO> pageQueryDTO, Function<DTO, LambdaQueryWrapper<T>> func);
    int count(DTO dto);
    int count(DTO dto, Function<DTO, LambdaQueryWrapper<T>> func);
}
