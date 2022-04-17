package com.zkq.platform.webcommon.entity.dto;

import lombok.Data;

/**
 * 分页参数传输对象
 * @param <T>
 */
@Data
public class PageQueryDTO<T> {
    private int current;
    private int size;
    private T entity;
    private String order;       //排序字段，多个字段使用逗号分隔
    private String orderType;   //排序类型asc:升序，desc：降序
}
