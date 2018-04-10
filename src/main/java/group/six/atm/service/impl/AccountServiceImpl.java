package group.six.atm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import group.six.atm.dao.AccountMapper;
import group.six.atm.dao.BussLogMapper;
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
	private BussLogMapper bussLogMapper;
	
	public void setAccountMapper(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}
	
	public void setBussLogMapper(BussLogMapper bussLogMapper) {
		this.bussLogMapper = bussLogMapper;
	}

	@Override
	public Account findAccountByUser(User user) {
		return accountMapper.selectByUserId(user.getId());
	}

	@Override
	public Double getBalance() {
		return null;
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		
	}

	@Override
	public Account getAccountData() {
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
	public BussLog transfer(Long amount, LoginObject loginObject, Account payeeAccount) {
		return null;
	}

}
