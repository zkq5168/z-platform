package com.zkq.platform.code.mapper;

import com.zkq.platform.code.entity.po.TColumn;
import com.zkq.platform.code.entity.po.TTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MysqlTableMapper {
    /**
     * 列表获取表名
     * @return
     */
    @Select("select TABLE_SCHEMA,TABLE_NAME,TABLE_COMMENT from information_schema.TABLES where TABLE_SCHEMA=(select database())")
    List<TTable> listTable();

    /**
     * 根据表名获取表名相关信息
     * @param tableName
     * @return
     */
    @Select("select TABLE_SCHEMA,TABLE_NAME,TABLE_COMMENT from information_schema.TABLES where TABLE_SCHEMA=(select database()) and TABLE_NAME=#{tableName}")
    TTable getTable(String tableName);

    /**
     * 列表获取表字段信息
     * @param tableName
     * @return
     */
    @Select("select TABLE_SCHEMA,TABLE_NAME,COLUMN_NAME,ORDINAL_POSITION,COLUMN_DEFAULT,IS_NULLABLE,DATA_TYPE,CHARACTER_MAXIMUM_LENGTH,NUMERIC_PRECISION,NUMERIC_SCALE,CHARACTER_SET_NAME,COLUMN_TYPE,COLUMN_KEY,EXTRA,COLUMN_COMMENT from information_schema.COLUMNS where TABLE_SCHEMA = (select database()) and TABLE_NAME=#{tableName}")
    List<TColumn> listTableColumn(String tableName);
}
