package group.six.atm.dto;

import group.six.atm.entity.ATM;
import group.six.atm.entity.Account;

/**
 * 登录时使用的对象，即存放在Session中的对象
 * @author hayate
 *
 */
public class LoginObject {
	
	/**
	 * 账户
	 */
	private Account account;
	/**
	 * ATM
	 */
	private ATM ATM;
	
	/**
	 * 
	 * @param ATM ATM对象
	 * @param account 账户对象
	 */
	public LoginObject(ATM ATM, Account account) {
		this.ATM = ATM;
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public ATM getATM() {
		return ATM;
	}

	public void setATM(ATM aTM) {
		ATM = aTM;
	}

}
