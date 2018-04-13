package group.six.atm.service;

import group.six.atm.dto.LoginObject;
import group.six.atm.entity.BussLog;

public interface IWithdrawService {
	
	/**
	 * 取款
	 * @param amount 金额，100的整数
	 * @param loginObject
	 * @return 取款记录
	 */
	BussLog withdraw(Long amount, LoginObject loginObject);
}
