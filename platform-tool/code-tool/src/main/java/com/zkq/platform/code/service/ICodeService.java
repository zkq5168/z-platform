package com.zkq.platform.code.service;

import com.zkq.platform.code.entity.dto.CodeGeneratorDTO;
import com.zkq.platform.code.entity.po.TColumn;

import java.util.List;

/**
 * 代码业务逻辑接口
 * @author zkq
 * @date 2022-04-14
 */
public interface ICodeService {
    /**
     * 生成代码
     * @param codeGeneratorDTO
     * @return
     */
    boolean generate(CodeGeneratorDTO codeGeneratorDTO);

    /**
     * 获取表格的所有列
     * @param tablename
     */
    List<TColumn> listColumn(String tablename);
}
