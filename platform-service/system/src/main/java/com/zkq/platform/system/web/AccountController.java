package com.zkq.platform.system.web;

import com.zkq.platform.system.entity.dto.AccountDTO;
import com.zkq.platform.system.entity.po.TAccount;
import com.zkq.platform.system.entity.vo.AccountVO;
import com.zkq.platform.system.service.IAccountService;
import com.zkq.platform.webcommon.web.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账号控制器类
 * @author zkq
 * @date 2022-04-13
 */
@RestController
@RequestMapping("/account")
public class AccountController extends BaseController<IAccountService, TAccount, AccountDTO, AccountVO> {
}
