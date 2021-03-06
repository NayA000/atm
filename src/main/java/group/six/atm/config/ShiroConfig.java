package group.six.atm.config;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.Filter;

import group.six.atm.shiro.LoginObjectRealm;
import group.six.atm.shiro.filter.LoginFilter;

@Configuration
public class ShiroConfig {
	
	/**
	 * 创建缓存实例
	 */
	@Bean("shiroEhCacheManager")
	public EhCacheManager shiroEhCacheManager() {
		EhCacheManager cm = new EhCacheManager();
		cm.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
		return cm;
	}

	@Bean("sessionManager")
	public SessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		// 设置session过期时间为1小时(单位：毫秒)，默认为30分钟
		sessionManager.setGlobalSessionTimeout(60 * 60 * 1000);
		sessionManager.setSessionValidationSchedulerEnabled(true);
		// 去除地址栏JSESSIONID参数
		sessionManager.setSessionIdUrlRewritingEnabled(false);
		/*sessionManager.setSessionIdCookieEnabled(true);
		sessionManager.setSessionIdCookie(sessionIdCookie());*/
		return sessionManager;
	}
	
	/*@Bean("sessionIdCookie")
	public SimpleCookie sessionIdCookie() {
		SimpleCookie simpleCookie = new SimpleCookie("shiro.sesssion");
		simpleCookie.setPath("/");
		simpleCookie.setName("WEBSID");
		return simpleCookie;
	}*/

	@Bean("securityManager")
	public SecurityManager securityManager(LoginObjectRealm loginObjectRealm, SessionManager sessionManager) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(loginObjectRealm);
		securityManager.setSessionManager(sessionManager);
		securityManager.setCacheManager(shiroEhCacheManager());
		return securityManager;
	}

	@Bean("shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		shiroFilter.setSecurityManager(securityManager);
		
		// 配置过滤器
		Map<String, Filter> filters = new LinkedHashMap<>();
		filters.put("login", loginFilter()); // 登录过滤器
		shiroFilter.setFilters(filters);
		//shiroFilter.setLoginUrl("/not_login");
		//shiroFilter.setUnauthorizedUrl("/no_access");
		// 放权请求
		Map<String, String> filterMap = new LinkedHashMap<>();
		filterMap.put("/sign_in", "anon");
		filterMap.put("/logout", "logout");
		filterMap.put("/**", "login,authc");// 拦截所有请求
		shiroFilter.setFilterChainDefinitionMap(filterMap);
		return shiroFilter;
	}
	
	/**
	 * 登录过滤器
	 */
	@Bean
	public LoginFilter loginFilter() {
		return new LoginFilter();
	}
	
	/*@Bean
	public LogoutFilter logoutFilter() {
		LogoutFilter logoutFilter = new LogoutFilter();
		logoutFilter.setRedirectUrl("/log_out");
		return logoutFilter;
	}*/

	@Bean("lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
		proxyCreator.setProxyTargetClass(true);
		return proxyCreator;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager);
		return advisor;
	}
	
}
