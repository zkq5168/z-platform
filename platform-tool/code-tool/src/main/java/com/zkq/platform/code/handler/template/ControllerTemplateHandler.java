package com.zkq.platform.code.handler.template;

import com.zkq.platform.code.entity.dto.CodeGeneratorDTO;
import com.zkq.platform.code.entity.po.TTable;

/**
 * 控制器代码生成器
 * @author zkq
 * @date 2022-04-16
 */
public class ControllerTemplateHandler extends DefaultTemplateHandler {

    public ControllerTemplateHandler(CodeGeneratorDTO codeGeneratorDTO, TTable table) {
        super(codeGeneratorDTO, table);
        this.templatePath = "/template/code/web/TemplateController.java.template";
        this.filename = templatePath.replaceAll(".template", "")
                .replaceAll("/template", "")
                .replaceAll("Template", codeGeneratorDTO.getClassname());
    }
}
