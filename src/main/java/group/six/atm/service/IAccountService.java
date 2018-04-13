package group.six.atm.service;

import javax.security.auth.login.AccountException;

import group.six.atm.dto.LoginObject;
import group.six.atm.entity.Account;
import group.six.atm.entity.User;

public interface IAccountService {
	
	/**
	 * 根据用户查找账户
	 * @param user
	 * @return 账户
	 */
	Account findAccountByUser(User user);
	
	/**
	 * 根据卡号获取账户
	 * @param cardNumber 卡号
	 * @return 账户
	 */
	Account findAccountByCardNumber(String cardNumber);
	
	/**
	 * 查询余额
	 * @return 余额
	 */
	Double getBalance(LoginObject loginObject);
	
	/**
	 * 修改密码
	 * @param loginObject 登录对象
	 * @param oldPassword 新密码
	 * @param newPassword 旧密码
	 */
	void changePassword(LoginObject loginObject, String oldPassword, String newPassword) throws AccountException ;
	
	/**
	 * 冻结账户
	 * @param loginObject 登录对象
	 */
	void freezeAccount(LoginObject loginObject);
	
	/**
	 * 查询个人信息
	 * @param loginObject 登录对象
	 * @return 账户对象
	 */
	Account getAccountData(LoginObject loginObject);
	
}
