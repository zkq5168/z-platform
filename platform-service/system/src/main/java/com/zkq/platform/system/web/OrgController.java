package com.zkq.platform.system.web;

import com.zkq.platform.base.entity.vo.TreeVO;
import com.zkq.platform.system.entity.dto.OrgDTO;
import com.zkq.platform.system.entity.po.TOrg;
import com.zkq.platform.system.entity.vo.OrgVO;
import com.zkq.platform.system.service.IOrgService;
import com.zkq.platform.system.util.OrgBeanUtil;
import com.zkq.platform.webcommon.entity.Result;
import com.zkq.platform.webcommon.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 组织表控制器
 * @author zkq
 * @date 2022-04-20
 */
@RestController
@RequestMapping("/org")
public class OrgController extends BaseController<IOrgService, TOrg, OrgDTO, OrgVO> {
    @Autowired
    private IOrgService orgService;

    /**
     * 获取组织单位树
     * @return
     */
    @GetMapping("/getOrgTree")
    public Result getOrgTree(){
        List<TreeVO> orgTree = orgService.getOrgTree();
        return Result.success(orgTree);
    }

    /**
     * 根据单位获取部门列表
     * @return
     */
    @GetMapping("/listDept")
    public Result listDept(@RequestParam("current") int current,
            @RequestParam("size") int size,
            @RequestParam("id") String companyId){
        List<OrgDTO> orgDTOList = orgService.listDept(companyId);
        List<OrgVO> orgVOList = OrgBeanUtil.INSTANCE.listDtoToVo(orgDTOList);
        return Result.success(orgVOList);
    }
}
