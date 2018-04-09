package group.six.atm.service.impl;

import org.springframework.stereotype.Service;

import group.six.atm.entity.Account;
import group.six.atm.entity.User;
import group.six.atm.service.IAccountService;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

	@Override
	public Account findAccountByUser(User user) {
		return null;
	}

}
