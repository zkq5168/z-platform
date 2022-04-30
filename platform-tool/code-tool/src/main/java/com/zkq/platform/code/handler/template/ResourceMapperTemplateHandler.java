package com.zkq.platform.code.handler.template;

import cn.hutool.core.util.StrUtil;
import com.zkq.platform.code.entity.dto.CodeGeneratorDTO;
import com.zkq.platform.code.entity.po.TColumn;
import com.zkq.platform.code.entity.po.TTable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 业务逻辑接口代码生成器
 * @author zkq
 * @date 2022-04-16
 */
public class ResourceMapperTemplateHandler extends DefaultTemplateHandler {
    public ResourceMapperTemplateHandler(CodeGeneratorDTO codeGeneratorDTO, TTable table) {
        super(codeGeneratorDTO, table);
        this.templatePath = "/template/resource/com/zkq/platform/module/mapper/TemplateMapper.xml.template";
        this.filename = templatePath.replaceAll(".template", "")
                .replaceAll("/template", "")
                .replaceAll("module", codeGeneratorDTO.getModule())
                .replaceAll("Template", codeGeneratorDTO.getClassname());
    }

    @Override
    public String extendTransfer(String codeContent) {
        //处理Mapper文件的循环逻辑循环逻辑
        StringBuilder sbCodeList = new StringBuilder();
        StringBuilder sbField = new StringBuilder();
        Pattern pattern = Pattern.compile("\\{\\{\\{.*}}}");
        Matcher matcher = pattern.matcher(codeContent);
        while(matcher.find()){
            String matchCode = matcher.group(0).replaceAll("\\{\\{\\{", "").replaceAll("}}}", "");
            for (TColumn column : this.columnList) {
                String transferCode = matchCode;
                //添加字段列表
                sbField.append(column.getColumnName()).append(",");
                //添加字段属性匹配参数
                Map<String, String> columnParam = new HashMap<>();
                if ("PRI".equals(column.getColumnKey())){
                    columnParam.put("type", "id");
                }else{
                    columnParam.put("type", "result");
                }
                columnParam.put("column_name", column.getColumnName());
                if ("varchar".equals(column.getDataType())){
                    columnParam.put("column_type", "VARCHAR");
                }else if ("datetime".equals(column.getDataType())){
                    columnParam.put("column_type", "TIMESTAMP");
                }else if ("int".equals(column.getDataType())){
                    columnParam.put("column_type", "INTEGER");
                }

                columnParam.put("property", StrUtil.toCamelCase(column.getColumnName()));

                Iterator<Map.Entry<String, String>> it = columnParam.entrySet().iterator();
                while (it.hasNext()){
                    Map.Entry<String, String> entry = it.next();
                    String key = entry.getKey();
                    String value = entry.getValue();

                    transferCode = transferCode.replaceAll("\\{\\{" + key + "}}", value);
                }
                sbCodeList.append(transferCode).append("\n\t");
            }
            //替换循环部分代码
            codeContent = matcher.replaceFirst(sbCodeList.deleteCharAt(sbCodeList.length()-2).toString());
            //替换字段列表部分代码
            codeContent = codeContent.replaceAll("\\{\\{column_join}}", sbField.deleteCharAt(sbField.length()-1).toString());
        }

        return codeContent;
    }
}
