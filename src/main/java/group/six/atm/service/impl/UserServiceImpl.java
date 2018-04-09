package group.six.atm.service.impl;

import org.springframework.stereotype.Service;

import group.six.atm.entity.User;
import group.six.atm.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Override
	public User findUserByCardNumber(String cardNumber) {
		return null;
	}

}
