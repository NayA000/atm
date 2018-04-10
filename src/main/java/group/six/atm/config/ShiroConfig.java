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

import group.six.atm.shiro.LoginObjectRealm;

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

		return sessionManager;
	}

	@Bean("securityManager")
	public SecurityManager securityManager(EhCacheManager shiroEhCacheManager, LoginObjectRealm loginObjectRealm, SessionManager sessionManager) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(loginObjectRealm);
		securityManager.setSessionManager(sessionManager);
		securityManager.setCacheManager(shiroEhCacheManager);
		return securityManager;
	}

	@Bean("shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		shiroFilter.setSecurityManager(securityManager);
		shiroFilter.setLoginUrl("/login.jhtml");
		shiroFilter.setUnauthorizedUrl("/no_access");
		Map<String, String> filterMap = new LinkedHashMap<>();
		// 放权请求
		filterMap.put("/sign_in", "anon");
		// 拦截所有请求
		filterMap.put("/**", "authc");
		shiroFilter.setFilterChainDefinitionMap(filterMap);
		return shiroFilter;
	}

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
