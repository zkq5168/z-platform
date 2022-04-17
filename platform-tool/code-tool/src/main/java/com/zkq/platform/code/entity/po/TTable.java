package com.zkq.platform.code.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("TABLES")
public class TTable {
    @TableField("TABLE_COMMENT")
    private String tableComment;    //表注释
    @TableField("TABLE_NAME")
    private String tableName;       //表名
    @TableField("TABLE_SCHEMA")
    private String tableSchema;     //数据库名
}
