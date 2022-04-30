package com.zkq.platform.base.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * 树节点的VO对象
 * @author zkq
 * @date 2022-04-26
 */
@Data
public class TreeVO {
    /**
     * 当前树节点的ID
     */
    private String id;
    /**
     * 当前树节点的标签名称
     */
    private String label;
    /**
     * 当前树的子节点
     */
    private List<TreeVO> children;
    /**
     * 当前对象数据
     */
    private Object entity;
}
