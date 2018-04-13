package group.six.atm.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import group.six.atm.dto.Result;
import group.six.atm.service.IAccountService;

@RestController
@RequestMapping("/deposit")
@RequiresRoles("USER")
public class DepositController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private IAccountService accountService;

	public void setAccountService(IAccountService accountService) {
		this.accountService = accountService;
	}
	
	/**
	 * 存款
	 * @param amount 金额
	 */
	@RequestMapping(method=RequestMethod.PUT)
	public Result deposit(@RequestParam("amount") Long amount) {
		return null;
	}
}
