package group.six.atm.service;

import group.six.atm.dto.LoginObject;
import group.six.atm.entity.Account;
import group.six.atm.entity.BussLog;
import group.six.atm.entity.User;

public interface IAccountService {
	
	/**
	 * 根据用户查找账户
	 * @param user
	 * @return
	 */
	Account findAccountByUser(User user);
	
	/**
	 * 查询余额
	 * @return
	 */
	Double getBalance();
	
	/**
	 * 修改密码
	 * @param oldPassword 新密码
	 * @param newPassword 旧密码
	 */
	void changePassword(String oldPassword, String newPassword);
	
	/**
	 * 查询个人信息
	 * @return 账户对象
	 */
	Account getAccountData();
	
	/**
	 * 存款
	 * @param amount 金额，100的整数
	 * @param loginObject
	 * @return 存款记录
	 */
	BussLog deposit(Long amount, LoginObject loginObject);
	
	/**
	 * 
	 * @param amount 金额，100的整数
	 * @param loginObject
	 * @return 取款记录
	 */
	BussLog withdraw(Long amount, LoginObject loginObject);
	
	/**
	 * 转账
	 * @param amount 金额，100的整数
	 * @param loginObject
	 * @param payeeAccount
	 * @return 转账记录
	 */
	BussLog transfer(Long amount, LoginObject loginObject, Account payeeAccount);

}
