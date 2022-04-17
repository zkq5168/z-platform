package com.zkq.platform.webcommon.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zkq.platform.webcommon.entity.dto.PageQueryDTO;
import com.zkq.platform.webcommon.service.IBaseService;

import java.util.List;
import java.util.function.Function;

/**
 * 基础业务逻辑实现类
 * @param <M>
 * @param <T>
 * @param <DTO>
 */
public abstract class BaseServiceImpl<M extends BaseMapper<T>, T, DTO> extends ServiceImpl<M, T> implements IBaseService<T, DTO> {
    public abstract T generateUUID(T t);

    public abstract T dtoToPo(DTO dto);

    public abstract DTO poToDto(T entity);

    public abstract List<DTO> listPoToDto(List<T> source);

    public abstract Page<DTO> pagePoToDto(Page<T> source);

    @Override
    public DTO saveEntity(DTO dto) {
        T entity = dtoToPo(dto);
        generateUUID(entity);
        getBaseMapper().insert(entity);
        return poToDto(entity);
    }

    @Override
    public int deleteById(String id) {
        return getBaseMapper().deleteById(id);
    }

    @Override
    public int deleteByIds(List<String> ids) {
        return getBaseMapper().deleteBatchIds(ids);
    }

    @Override
    public DTO update(DTO dto) {
        T entity = dtoToPo(dto);
        boolean result = updateById(entity);
        return result ? dto : null;
    }

    @Override
    public DTO getById(String id) {
        T entity = getBaseMapper().selectById(id);
        DTO dto = poToDto(entity);
        return dto;
    }

    @Override
    public List<DTO> list(DTO dto) {
        return list(dto, null);
    }

    @Override
    public List<DTO> list(DTO dto, Function<DTO, LambdaQueryWrapper<T>> func) {
        LambdaQueryWrapper<T> query = new LambdaQueryWrapper<>();
        if (func != null){
            query = func.apply(dto);
        }
        List<T> entityList = getBaseMapper().selectList(query);
        return listPoToDto(entityList);
    }

    @Override
    public Page<DTO> page(PageQueryDTO<DTO> pageQueryDTO) {
        return page(pageQueryDTO, null);
    }

    @Override
    public Page<DTO> page(PageQueryDTO<DTO> pageQueryDTO, Function<DTO, LambdaQueryWrapper<T>> func) {
        int current = pageQueryDTO.getCurrent();
        int size = pageQueryDTO.getSize();
        Page<T> page = new Page<>(current, size);
        LambdaQueryWrapper<T> query = new LambdaQueryWrapper<>();
        if (func != null){
            DTO dto = pageQueryDTO.getEntity();
            query = func.apply(dto);
        }
        return pagePoToDto(page(page, query));
    }

    @Override
    public int count(DTO dto) {
        return count(dto, null);
    }

    @Override
    public int count(DTO dto, Function<DTO, LambdaQueryWrapper<T>> func){
        LambdaQueryWrapper<T> query = new LambdaQueryWrapper<>();
        if (func != null){
            query = func.apply(dto);
        }
        return count(query);
    }
}
