package com.zkq.platform.system.service;

import com.zkq.platform.base.entity.vo.TreeVO;
import com.zkq.platform.system.entity.dto.OrgDTO;
import com.zkq.platform.system.entity.po.TOrg;
import com.zkq.platform.webcommon.service.IBaseService;

import java.util.List;

/**
 * 组织表业务逻辑处理接口
 * @author t_org
 * @date 2022-04-20
 */
public interface IOrgService extends IBaseService<TOrg, OrgDTO> {
    /**
     * 获取组织单位树
     * @return
     */
    List<TreeVO> getOrgTree();

    /**
     * 根据单位获取部门列表
     * @param companyId
     * @return
     */
    List<OrgDTO> listDept(String companyId);
}
