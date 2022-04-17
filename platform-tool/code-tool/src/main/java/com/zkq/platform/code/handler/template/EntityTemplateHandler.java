package com.zkq.platform.code.handler.template;

import cn.hutool.core.util.StrUtil;
import com.zkq.platform.code.entity.dto.CodeGeneratorDTO;
import com.zkq.platform.code.entity.po.TColumn;
import com.zkq.platform.code.entity.po.TTable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EntityTemplateHandler extends DefaultTemplateHandler {
    public EntityTemplateHandler(CodeGeneratorDTO codeGeneratorDTO, TTable table) {
        super(codeGeneratorDTO, table);
    }

    @Override
    public String extendTransfer(String codeContent) {
        //处理循环逻辑
        StringBuilder sbCodeList = new StringBuilder();
        Pattern pattern = Pattern.compile("\\{\\{\\{(\\w|\\W)*}}}");
        Matcher matcher = pattern.matcher(codeContent);
        while(matcher.find()){
            String placeHolder = matcher.group(0);
            for (TColumn column : this.columnList) {
                Map<String, String> columnParam = new HashMap<>();
                columnParam.put("column_comment", column.getColumnComment());
                columnParam.put("property", StrUtil.toCamelCase(column.getColumnName()));
                if ("PRI".equals(column.getColumnKey())){
                    columnParam.put("annotation", "@TableId(\"" + column.getColumnName() + "\")");
                }else{
                    columnParam.put("annotation", "@TableField(\"" + column.getColumnName() + "\")");
                }
                if ("varchar".equals(column.getDataType())){
                    columnParam.put("type", "String");
                }else if ("datetime".equals(column.getDataType())){
                    columnParam.put("type", "Date");
                }

                String subCodeContent = placeHolder;
                subCodeContent = subCodeContent.replaceAll("\\{\\{\\{", "")
                        .replaceAll("}}}", "");
                Iterator<Map.Entry<String, String>> it = columnParam.entrySet().iterator();
                while (it.hasNext()){
                    Map.Entry<String, String> entry = it.next();
                    String key = entry.getKey();
                    String value = entry.getValue();

                    subCodeContent = subCodeContent.replaceAll("\\{\\{" + key + "}}", value);
                }
                sbCodeList.append(subCodeContent);
            }
            codeContent = matcher.replaceFirst(sbCodeList.toString());
        }

        return codeContent;
    }
}
