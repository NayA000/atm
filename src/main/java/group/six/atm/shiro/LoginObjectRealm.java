package group.six.atm.shiro;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import group.six.atm.dto.LoginObject;
import group.six.atm.entity.ATM;
import group.six.atm.entity.Account;
import group.six.atm.entity.User;
import group.six.atm.exceptions.SystemException;
import group.six.atm.service.IATMService;
import group.six.atm.service.IAccountService;
import group.six.atm.service.IUserService;

/**
 * 认证Realm
 */
@Component
public class LoginObjectRealm extends AuthorizingRealm {

	public static final String USER = "USER";
	public static final String FREEZED_USER = "FREEZED_USER";
	public static final String DELETED_USER = "DELETED_USER";

	@Autowired
	private IATMService ATMService;
	@Autowired
	private IAccountService accountService;
	@Autowired
	private IUserService userService;

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setATMService(IATMService ATMServicre) {
		this.ATMService = ATMServicre;
	}

	public void setAccountService(IAccountService accountService) {
		this.accountService = accountService;
	}

	/**
	 * 授权(验证权限时调用)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		LoginObject loginObject = (LoginObject) principals.getPrimaryPrincipal();
		// 存放权限信息
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 普通登录
		if (loginObject.getAccount() != null && loginObject.getAccount() instanceof Account) {
			switch (loginObject.getAccount().getStatus()) {
			case 0: // 正常用户
				info.addRole(USER);
				break;
			case 1: // 已冻结的用户
				info.addRole(FREEZED_USER);
				break;
			case 2: // 已注销的用户
				info.addRole(DELETED_USER);
				break;
			default:
				info.addRole(null);
			}
		}
		// 管理员登录（预留）...

		return info;
	}

	/**
	 * 认证(登录时调用)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 字段包含ATM_ID和cardNUmber，用">>"分隔
		String ATM_ID_and_cardnumber = (String) token.getPrincipal();
		String[] strings = StringUtils.split(ATM_ID_and_cardnumber, ">>");
		// 获取ATM
		ATM ATM = StringUtils.isBlank(strings[0]) ? null : ATMService.findATMById(Long.parseLong(strings[0]));
		if(ATM == null){
			throw new SystemException("系统异常，请联系管理员");
		}
		// 获取用户
		User user = userService.findUserByCardNumber(strings[1]);
		// 获取账户
		Account account = user == null ? null : this.accountService.findAccountByUser(user);
		if (account == null) {
			throw new UnknownAccountException("账号或密码不正确");
		}
		// 封装登录对象
		LoginObject loginObject = new LoginObject(ATM, account);
		Date freezeTimeStamp = account.getFreezeTimeStamp();
		// 判断是否为锁定24小时状态
		if (freezeTimeStamp != null) {
			long difference = DateUtils.toCalendar(freezeTimeStamp).getTimeInMillis()
					- DateUtils.toCalendar(new Date()).getTimeInMillis();
			// 相差天数
			long day = difference / (3600 * 24 * 1000);
			if (day < 1) {
				throw new LockedAccountException();
			}
		}
		// 判断账户是否被冻结
		if (account.getStatus() == 1) {
			throw new LockedAccountException();
		}
		// 参数分别是对象，凭证(会拿去和登陆逻辑参数比较)
		return new SimpleAuthenticationInfo(loginObject, loginObject.getAccount().getPassword(), getName());
	}

}