package group.six.atm.service;

import group.six.atm.entity.User;

public interface IUserService {
	
	/**
	 * 根据卡号查找用户
	 * @return
	 */
	User findUserByCardNumber(String cardNumber);
	
}
