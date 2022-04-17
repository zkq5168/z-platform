package com.zkq.platform.system.web;

import com.zkq.platform.system.entity.dto.CompanyDTO;
import com.zkq.platform.system.entity.po.TCompany;
import com.zkq.platform.system.entity.vo.CompanyVO;
import com.zkq.platform.system.service.ICompanyService;
import com.zkq.platform.webcommon.web.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 单位管理控制器
 * @author zkq
 * @date 2022-04-13
 */
@RestController
@RequestMapping("/company")
public class CompanyController extends BaseController<ICompanyService, TCompany, CompanyDTO, CompanyVO> {
}
