package group.six.atm.dao;

import group.six.atm.entity.Account;

public interface AccountMapper extends BaseMapper<Account, Long>{
	
	/**
	 * 根据ID查询账户
	 * @param userID
	 * @return
	 */
	Account selectByUserId(Long userID);
	
}