package group.six.atm.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;


/**
 * 认证Realm
 */
@Component
public class AccountRealm extends AuthorizingRealm {
	
    /**
     * 授权(验证权限时调用)
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//User user = (User) principals.getPrimaryPrincipal();
		//存放权限信息
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		/*switch (user.getType()){
			case 1:		//运营人员  type==1
				info.addRole("OPERATOR");
				break;
			case 9:		//超级管理员
				info.addRole("ADMIN");
				break;
			default:
				info.addRole(null);
		}*/

		return info;
	}

	/**
	 * 认证(登录时调用)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		/*String account = (String) token.getPrincipal();
		// 获取账户登录信息
		User user = this.userService.getUserByAccount(account);

		//账号不存在
		if(user == null) {
			throw new UnknownAccountException("账号或密码不正确");
		}
		if(user.getCanuse()==0){
			 throw new LockedAccountException();
		}
		//参数分别是对象，凭证(会拿去和登陆逻辑参数比较)，真实姓名
		return new SimpleAuthenticationInfo(user,
				user.getPasswd(), getName());*/
		return null;
	}

}