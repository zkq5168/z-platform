package com.zkq.platform.code.entity.dto;

import com.zkq.platform.code.entity.po.TColumn;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 代码生成器DTO
 * @author zkq
 * @date 2022-04-14
 */
@Data
public class CodeGeneratorDTO {
    private String module;              //模块名
    private String tablename;           //表名
    private String classname;           //类名
    private String author;              //作者名
    private String codeDir;             //代码生成目录
    private List<TColumn> columnList;   //字段列表
}
