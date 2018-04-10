package group.six.atm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.six.atm.dao.UserMapper;
import group.six.atm.entity.User;
import group.six.atm.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User findUserByCardNumber(String cardNumber) {
		return userMapper.selectUserByCardNumber(cardNumber);
	}

}
