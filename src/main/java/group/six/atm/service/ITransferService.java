package group.six.atm.service;

import group.six.atm.dto.LoginObject;
import group.six.atm.entity.BussLog;

public interface ITransferService {
	
	/**
	 * 转账
	 * @param amount 金额，100的整数
	 * @param loginObject 当前登录账户
	 * @param payeeCardNumber 收款账户卡号 
	 * @return 转账记录
	 */
	BussLog transfer(Long amount, LoginObject loginObject, String payeeCardNUmber);
	
}
