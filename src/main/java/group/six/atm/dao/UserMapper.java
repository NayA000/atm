package group.six.atm.dao;

import group.six.atm.entity.User;

public interface UserMapper extends BaseMapper<User, Long> {
	
	/**
	 * 根据卡号查找用户
	 * @param cardNumber
	 * @return 用户
	 */
	User selectUserByCardNumber(String cardNumber);
	
}