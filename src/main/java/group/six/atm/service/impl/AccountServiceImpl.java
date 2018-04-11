package group.six.atm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.six.atm.dao.AccountMapper;
import group.six.atm.dao.BussLogMapper;
import group.six.atm.dao.UserMapper;
import group.six.atm.dto.LoginObject;
import group.six.atm.entity.Account;
import group.six.atm.entity.BussLog;
import group.six.atm.entity.User;
import group.six.atm.service.IAccountService;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
	
	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private BussLogMapper bussLogMapper;
	
	public void setAccountMapper(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public void setBussLogMapper(BussLogMapper bussLogMapper) {
		this.bussLogMapper = bussLogMapper;
	}

	@Override
	public Account findAccountByUser(User user) {
		return accountMapper.selectByUserId(user.getId());
	}
	
	@Override
	public Account findAccountByCardNumber(String cardNumber) {
		// 获取用户
		User user = userMapper.selectUserByCardNumber(cardNumber);
		// 获取账户
		Account account = user == null ? null : this.findAccountByUser(user);
		return account;
	}

	@Override
	public Double getBalance(LoginObject loginObject) {
		// 重新查询账户
		Account account = this.findAccountByUser(loginObject.getAccount().getUser());
		return account.getBalance();
	}

	@Override
	public void changePassword(LoginObject loginObject, String oldPassword, String newPassword) {
		
	}
	
	@Override
	public void freezePassord(LoginObject loginObject) {
	}

	@Override
	public Account getAccountData(LoginObject loginObject) {
		return null;
	}

	@Override
	public BussLog deposit(Long amount, LoginObject loginObject) {
		return null;
	}

	@Override
	public BussLog withdraw(Long amount, LoginObject loginObject) {
		return null;
	}

	@Override
	public BussLog transfer(Long amount, LoginObject loginObject, String payeeCardNumber) {
		return null;
	}

}
