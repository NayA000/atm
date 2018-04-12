package group.six.atm.service.impl;

import java.util.Date;

import javax.security.auth.login.AccountException;

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
import group.six.atm.utils.Cryptography;

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
	public void changePassword(LoginObject loginObject, String oldPassword, String newPassword) throws AccountException {
		boolean correct = Cryptography.checkMd5Hash(oldPassword, oldPassword, loginObject.getAccount().getUser().getCard().getCardNumber());
		if (!correct) {
			throw new AccountException("原密码错误");
		}
		newPassword = Cryptography.MD5Hash(oldPassword, loginObject.getAccount().getUser().getCard().getCardNumber());
		Account temp = new Account();
		temp.setId(loginObject.getAccount().getId());
		// 只更新密码
		temp.setPassword(newPassword);
		accountMapper.updateByPrimaryKeySelective(temp);
	}
	
	@Override
	public void freezeAccount(LoginObject loginObject) {
		Account temp = new Account();
		temp.setId(loginObject.getAccount().getId());
		temp.setFreezeTimeStamp(new Date());
		accountMapper.updateByPrimaryKeySelective(temp);
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
