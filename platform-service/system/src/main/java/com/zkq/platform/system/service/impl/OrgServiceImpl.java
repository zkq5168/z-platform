package com.zkq.platform.system.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zkq.platform.base.entity.vo.TreeVO;
import com.zkq.platform.system.constant.SystemConstant;
import com.zkq.platform.system.entity.dto.OrgDTO;
import com.zkq.platform.system.entity.po.TOrg;
import com.zkq.platform.system.mapper.OrgMapper;
import com.zkq.platform.system.service.IOrgService;
import com.zkq.platform.system.util.OrgBeanUtil;
import com.zkq.platform.webcommon.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 组织表业务逻辑处理实现类
 * @author t_org
 * @date 2022-04-20
 */
@Service
public class OrgServiceImpl extends BaseServiceImpl<OrgMapper, TOrg, OrgDTO> implements IOrgService {
    @Override
    public TOrg generateUUID(TOrg tOrg) {
        if (StrUtil.isEmpty(tOrg.getOrgId())){
            tOrg.setOrgId(IdUtil.simpleUUID());
        }
        return tOrg;
    }

    @Override
    public TOrg dtoToPo(OrgDTO source) {
        return OrgBeanUtil.INSTANCE.dtoToPo(source);
    }

    @Override
    public OrgDTO poToDto(TOrg source) {
        return OrgBeanUtil.INSTANCE.poToDto(source);
    }
    @Override
    public List<OrgDTO> listPoToDto(List<TOrg> source) {
        return OrgBeanUtil.INSTANCE.listPoToDto(source);
    }
    @Override
    public Page<OrgDTO> pagePoToDto(Page<TOrg> source) {
        return OrgBeanUtil.INSTANCE.pagePoToDto(source);
    }

    /**
     * 获取组织单位树
     * @return
     */
    @Override
    public List<TreeVO> getOrgTree() {
        List<TreeVO> treeList = new ArrayList<>();
        LambdaQueryWrapper<TOrg> query = new LambdaQueryWrapper();
        query.eq(TOrg::getParentOrgId, "-1");
        query.eq(TOrg::getOrgType, SystemConstant.OrgType.COMPANY);
        query.orderByAsc(TOrg::getDisplayOrder);
        // 获取顶层组织列表
        List<TOrg> orgList = getBaseMapper().selectList(query);

        TreeVO treeVO = null;
        for (TOrg org : orgList) {
            treeVO = new TreeVO();
            treeVO.setId(org.getOrgId());
            treeVO.setLabel(org.getOrgName());
            treeVO.setEntity(org);
            //获取子节点
            List<TreeVO> childTreeList = getChildOrg(org);
            treeVO.setChildren(childTreeList);

            treeList.add(treeVO);
        }

        return treeList;
    }

    /**
     * 获取子节点数据
     * @param org
     */
    private List<TreeVO> getChildOrg(TOrg org) {
        List<TreeVO> treeList = new ArrayList<>();

        LambdaQueryWrapper<TOrg> childQuery = new LambdaQueryWrapper();
        childQuery.eq(TOrg::getParentOrgId, org.getOrgId());
        childQuery.eq(TOrg::getOrgType, SystemConstant.OrgType.COMPANY);
        childQuery.orderByAsc(TOrg::getDisplayOrder);

        List<TOrg> orgChildList = getBaseMapper().selectList(childQuery);
        if (orgChildList != null && orgChildList.size() > 0){
            for (TOrg orgChild : orgChildList) {
                TreeVO treeVO = new TreeVO();
                treeVO.setId(orgChild.getOrgId());
                treeVO.setLabel(orgChild.getOrgName());
                treeVO.setEntity(orgChild);
                treeVO.setChildren(getChildOrg(orgChild));
                treeList.add(treeVO);
            }
        }

        return treeList;
    }

    /**
     * 根据单位获取部门列表
     * @param companyId
     * @return
     */
    @Override
    public List<OrgDTO> listDept(String companyId) {
        LambdaQueryWrapper<TOrg> query = new LambdaQueryWrapper();
        query.eq(TOrg::getParentOrgId, companyId);
        query.eq(TOrg::getOrgType, SystemConstant.OrgType.DEPT);
        query.orderByAsc(TOrg::getDisplayOrder);

        List<TOrg> orgPoList = list(query);
        return OrgBeanUtil.INSTANCE.listPoToDto(orgPoList);
    }
}
