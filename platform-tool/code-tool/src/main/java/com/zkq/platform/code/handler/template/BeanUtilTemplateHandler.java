package com.zkq.platform.code.handler.template;

import com.zkq.platform.code.entity.dto.CodeGeneratorDTO;
import com.zkq.platform.code.entity.po.TTable;

/**
 * 业务逻辑接口代码生成器
 * @author zkq
 * @date 2022-04-16
 */
public class BeanUtilTemplateHandler extends DefaultTemplateHandler {
    public BeanUtilTemplateHandler(CodeGeneratorDTO codeGeneratorDTO, TTable table) {
        super(codeGeneratorDTO, table);
        this.templatePath = "/template/code/util/TemplateBeanUtil.java.template";
        this.filename = templatePath.replaceAll(".template", "")
                .replaceAll("/template", "")
                .replaceAll("Template", codeGeneratorDTO.getClassname());
    }
}
