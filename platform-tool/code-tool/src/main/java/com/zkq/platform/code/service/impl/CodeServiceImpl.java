package com.zkq.platform.code.service.impl;

import cn.hutool.core.util.StrUtil;
import com.zkq.platform.code.entity.dto.CodeGeneratorDTO;
import com.zkq.platform.code.entity.po.TColumn;
import com.zkq.platform.code.entity.po.TTable;
import com.zkq.platform.code.exception.CodeGenerateException;
import com.zkq.platform.code.mapper.MysqlTableMapper;
import com.zkq.platform.code.service.ICodeService;
import com.zkq.platform.code.handler.template.DefaultTemplateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 代码管理逻辑处理实现类
 * @author zkq
 * @date 2022-04-14
 */
@Service
public class CodeServiceImpl implements ICodeService {
    @Autowired
    private MysqlTableMapper mysqlTableMapper;

    /**
     * 生成代码
     * @param codeGeneratorDTO
     * @return
     */
    @Override
    public boolean generate(CodeGeneratorDTO codeGeneratorDTO) {
        String tablename = codeGeneratorDTO.getTablename();

        if (StrUtil.isEmpty(codeGeneratorDTO.getTablename())){
            throw new CodeGenerateException("表名不能为空");
        }

        TTable tablePo = mysqlTableMapper.getTable(tablename);
        List<TColumn> columns = mysqlTableMapper.listTableColumn(tablename);
        codeGeneratorDTO.setColumnList(columns);
        DefaultTemplateHandler defaultTemplateHandler = DefaultTemplateHandler.getDefaultTemplateHandler(codeGeneratorDTO, tablePo);
        defaultTemplateHandler.process();
        return true;
    }

    /**
     * 根据表格获取字段列表
     * @param tablename
     */
    @Override
    public List<TColumn> listColumn(String tablename) {
        List<TColumn> columns = mysqlTableMapper.listTableColumn(tablename);
        return columns;
    }
}
