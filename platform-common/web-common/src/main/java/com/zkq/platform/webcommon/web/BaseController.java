package com.zkq.platform.webcommon.web;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zkq.platform.webcommon.entity.Result;
import com.zkq.platform.webcommon.entity.dto.PageQueryDTO;
import com.zkq.platform.webcommon.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

/**
 * 基础控制器类
 * @param <S>       逻辑处理类
 * @param <T>       PO实体类
 * @param <DTO>     DTO实体类
 * @param <VO>      VO实体类
 */
public class BaseController<S extends IBaseService<T, DTO>, T, DTO, VO> {
    @Autowired
    private S baseService;

    /**
     * 通用新增
     * @param entity
     * @return
     */
    @PostMapping("/save")
    public Result save(@RequestBody DTO entity){
        baseService.saveEntity(entity);
        return Result.success(entity);
    }

    /**
     * 根据ID删除数据
     * @param id
     * @return
     */
    @GetMapping("/deleteById")
    public Result deleteById(@RequestParam("id") String id){
        int ret = baseService.deleteById(id);
        return Result.success(ret);
    }

    /**
     * 根据id列表删除数据
     * @param ids
     * @return
     */
    @PostMapping("/deleteByIds")
    public Result deleteByIds(@RequestBody List<String> ids){
        int ret = baseService.deleteByIds(ids);
        return Result.success(ret);
    }

    /**
     * 通用修改
     * @param dto
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody DTO dto){
        baseService.update(dto);
        return Result.success(dto);
    }

    /**
     * 通用根据ID查询对象
     * @param id
     * @return
     */
    @GetMapping("/getById")
    public Result getById(@RequestParam("id") String id){
        DTO dto = baseService.getById(id);
        return Result.success(dto);
    }

    /**
     * 获取列表数据
     * @return
     */
    @PostMapping("/list")
    public Result list(@RequestBody DTO dto) {
        List<DTO> list = baseService.list(dto);
        return Result.success(list);
    }

    /**
     * 分页查询列表数据
     * @param pageQueryDTO
     * @return
     */
    @PostMapping("/page")
    public Result page(@RequestBody PageQueryDTO pageQueryDTO){
        Page page = baseService.page(pageQueryDTO);
        Result result = Result.success(page);
        result.setTotal(page.getTotal());
        return result;
    }

    /**
     * 统计条目数
     * @return
     */
    @PostMapping("/count")
    public Result count(@RequestBody DTO dto) {
        int count = baseService.count(dto);
        return Result.success(count);
    }
}
