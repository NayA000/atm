package group.six.atm.service;

import group.six.atm.entity.Account;
import group.six.atm.entity.User;

public interface IAccountService {
	
	/**
	 * 根据用户查找账户
	 * @param user
	 * @return
	 */
	Account findAccountByUser(User user);

}
