package group.six.atm.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import group.six.atm.dto.Result;
import group.six.atm.service.IAccountService;

@RestController
@RequestMapping("/transfer")
@RequiresRoles("USER")
public class TransferController {
	
	@Autowired
	private IAccountService accountService;

	public void setAccountService(IAccountService accountService) {
		this.accountService = accountService;
	}
	
	/**
	 * 转账
	 */
	@RequestMapping(method=RequestMethod.PUT)
	public Result deposit(@RequestParam("amount") Long amount, @RequestParam("payeeCardNumber") String payeeCardNumber) {
		return null;
	}
}
