package group.six.atm.service;

import group.six.atm.dto.LoginObject;
import group.six.atm.entity.BussLog;

public interface IDepositService {
	
	/**
	 * 存款
	 * @param amount 金额，100的整数
	 * @param loginObject
	 * @return 存款记录
	 */
	BussLog deposit(Long amount, LoginObject loginObject);
}
