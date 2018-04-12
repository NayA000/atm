package group.six.atm.controller;

import java.util.Date;

import javax.security.auth.login.AccountException;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import group.six.atm.dto.AccountDTO;
import group.six.atm.dto.Result;
import group.six.atm.entity.Account;
import group.six.atm.service.IAccountService;
import group.six.atm.shiro.ShiroUtils;
import group.six.atm.utils.BussCode;

@RestController
@RequestMapping("/account")
@RequiresRoles("USER")
public class AccountController {
	
	@Autowired
	private IAccountService accountService;

	public void setAccountService(IAccountService accountService) {
		this.accountService = accountService;
	}
	
	/**
	 * 查询用户信息
	 */
	@RequestMapping(method=RequestMethod.GET)
	public Result getAccountData() {
		// 获取Session中的对象
		Account account = ShiroUtils.getToken().getAccount();
		AccountDTO accountDTO = new AccountDTO();
		// 属性拷贝
		BeanUtils.copyProperties(account, accountDTO);
		Result rs = new Result();
		rs.put("account", accountDTO);
		return rs;
	}
	
	/**
	 * 获取账户余额
	 */
	@RequestMapping(value="/balance", method=RequestMethod.GET)
	public Result getBalance() {
		Result rs = new Result();
		rs.put("balacne", accountService.getBalance(ShiroUtils.getToken()));
		return rs;
	}
	
	/**
	 * 修改密码
	 * @param oldPassword 旧密码
	 * @param newPassword 新密码
	 */
	@RequestMapping(method=RequestMethod.PUT)
	public Result changePassword(@RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword) {
		try {
			accountService.changePassword(ShiroUtils.getToken(), oldPassword, newPassword);
		} catch (AccountException e) {
			return Result.error(BussCode.MODIFY_ERR, e.getMessage());
		} catch (Exception e) {
			return Result.error();
		}
		return Result.success();
	}
	
	/**
	 * 冻结账户
	 */
	public Result freezeAccount() {
		accountService.freezeAccount(ShiroUtils.getToken());
		return Result.success();
	}
	
}
