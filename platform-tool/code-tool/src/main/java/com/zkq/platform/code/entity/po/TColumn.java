package com.zkq.platform.code.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 表格的列信息
 * @author zkq
 * @date 2022-04-15
 */
@Data
@Accessors(chain = true)
@TableName("COLUMNS")
public class TColumn {
    @TableField("TABLE_SCHEMA")
    private String tableSchema;
    @TableField("TABLE_NAME")
    private String tableName;
    @TableField("COLUMN_NAME")
    private String columnName;
    @TableField("ORDINAL_POSITION")
    private String ordinalPosition;
    @TableField("COLUMN_DEFAULT")
    private String columnDefault;
    @TableField("IS_NULLABLE")
    private String isNullable;
    @TableField("DATA_TYPE")
    private String dataType;
    @TableField("CHARACTER_MAXIMUM_LENGTH")
    private String characterMaximumLength;
    @TableField("NUMERIC_PRECISION")
    private String numericPrecision;
    @TableField("NUMERIC_SCALE")
    private String numericScale;
    @TableField("CHARACTER_SET_NAME")
    private String characterSetName;
    @TableField("COLUMN_TYPE")
    private String columnType;
    @TableField("COLUMN_KEY")
    private String columnKey;
    @TableField("EXTRA")
    private String extra;
    @TableField("COLUMN_COMMENT")
    private String columnComment;
}
