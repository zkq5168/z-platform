package com.zkq.platform.code.handler.template;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import com.zkq.platform.code.entity.dto.CodeGeneratorDTO;
import com.zkq.platform.code.entity.po.TColumn;
import com.zkq.platform.code.entity.po.TTable;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * 模板处理抽象类
 * @author zkq
 * @date 2022-04-16
 */
@Slf4j
public class DefaultTemplateHandler {
    protected String filename;                  //生成代码的文件名
    protected String templatePath;              //模板文件的路径
    protected String codeDirectory;             //代码生成路径
    protected String tableName;                 //数据库表名
    private String className;                   //类名
    protected Map<String, String> params;       //替换参数
    protected TTable table;                     //表格信息
    protected List<TColumn> columnList;         //字段列表
    private DefaultTemplateHandler nextHandler;

    public DefaultTemplateHandler(CodeGeneratorDTO codeGeneratorDTO, TTable table){
        this.init(codeGeneratorDTO, table);
        this.params = new HashMap<>();
        this.params.put("tablename", codeGeneratorDTO.getTablename());
        this.params.put("author", codeGeneratorDTO.getAuthor());
        this.params.put("className", className);
        this.params.put("className.lower", className.toLowerCase());
        this.params.put("module", codeGeneratorDTO.getModule());
        this.params.put("comment", table.getTableComment());
        this.params.put("date", DateUtil.formatDate(new Date()));
        this.columnList = codeGeneratorDTO.getColumnList();
    }

    private void init(CodeGeneratorDTO codeGeneratorDTO, TTable table){
        codeDirectory = codeGeneratorDTO.getCodeDir();
        this.table = table;
        tableName = codeGeneratorDTO.getTablename().toLowerCase();
        int index = tableName.indexOf("_");
        String tableNameSuffix = tableName.substring(index+1);
        className = tableNameSuffix.substring(0, 1).toUpperCase() + tableNameSuffix.substring(1);
    }

    /**
     * 转换模板代码
     */
    public String translate(String templateContent, Map<String, String> params){
        Set<Map.Entry<String, String>> entries = params.entrySet();
        Iterator<Map.Entry<String, String>> it = entries.iterator();
        while (it.hasNext()){
            Map.Entry<String, String> entry = it.next();
            String key = entry.getKey();
            String value = entry.getValue();

            templateContent = templateContent.replaceAll("\\{\\{" + key + "}}", value);
        }
        return templateContent;
    }

    /**
     * 触发模板转换
     */
    public void process(){
        String templateContent = FileUtil.readUtf8String(this.getClass().getResource(templatePath).toString());
        String codeContent = translate(templateContent, params);

        codeContent = extendTransfer(codeContent);

        write(codeContent);
        if (nextHandler != null){
            nextHandler.process();
        }
    }

    /**
     * 额外的代码转换
     * @param codeContent
     * @return
     */
    public String extendTransfer(String codeContent) {
        return codeContent;
    }

    /**
     * 生成代码文件
     * @param codeContent
     */
    private void write(String codeContent){
        //获取写入目标地址
        String destFile = codeDirectory + filename;

        //写入目标文件
        FileUtil.writeUtf8String(codeContent, destFile);
    }

    /**
     * 获取默认的模板处理器链
     * @return
     */
    public static DefaultTemplateHandler getDefaultTemplateHandler(CodeGeneratorDTO codeGeneratorDTO, TTable table){
        ControllerTemplateHandler controllerTemplateHandler = new ControllerTemplateHandler(codeGeneratorDTO, table);
        ServiceInterfaceTemplateHandler serviceInterfaceTemplateHandler = new ServiceInterfaceTemplateHandler(codeGeneratorDTO, table);
        ServiceImplTemplateHandler serviceImplTemplateHandler = new ServiceImplTemplateHandler(codeGeneratorDTO, table);
        BeanUtilTemplateHandler beanUtilTemplateHandler = new BeanUtilTemplateHandler(codeGeneratorDTO, table);
        MapperTemplateHandler mapperTemplateHandler = new MapperTemplateHandler(codeGeneratorDTO, table);
        EntityPOTemplateHandler entityPOTemplateHandler = new EntityPOTemplateHandler(codeGeneratorDTO, table);
        EntityDTOTemplateHandler entityDTOTemplateHandler = new EntityDTOTemplateHandler(codeGeneratorDTO, table);
        EntityVOTemplateHandler entityVOTemplateHandler = new EntityVOTemplateHandler(codeGeneratorDTO, table);
        ResourceMapperTemplateHandler resourceMapperTemplateHandler = new ResourceMapperTemplateHandler(codeGeneratorDTO, table);

        controllerTemplateHandler.setNextHandler(serviceInterfaceTemplateHandler);
        serviceInterfaceTemplateHandler.setNextHandler(serviceImplTemplateHandler);
        serviceImplTemplateHandler.setNextHandler(beanUtilTemplateHandler);
        beanUtilTemplateHandler.setNextHandler(mapperTemplateHandler);
        mapperTemplateHandler.setNextHandler(entityPOTemplateHandler);
        entityPOTemplateHandler.setNextHandler(entityDTOTemplateHandler);
        entityDTOTemplateHandler.setNextHandler(entityVOTemplateHandler);
        entityVOTemplateHandler.setNextHandler(resourceMapperTemplateHandler);

        return controllerTemplateHandler;
    }

    /**
     * 获取下一个代码模板处理器
     * @return
     */
    public DefaultTemplateHandler getNextHandler() {
        return nextHandler;
    }

    /**
     * 设置下一个代码模板处理器
     * @param nextHandler
     */
    public void setNextHandler(DefaultTemplateHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

}
