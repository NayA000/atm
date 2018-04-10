package group.six.atm.config;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;

/**
 * 注册过滤器
 * @author Hayate
 *
 */
public class AppFilterInitializer implements WebApplicationInitializer{
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// 配置字符编码过滤器
		Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", CharacterEncodingFilter.class);
		characterEncodingFilter.setInitParameter("encoding", "utf-8");
		characterEncodingFilter.addMappingForUrlPatterns(null, false, "/*");
		
		// Shiro过滤器
		Dynamic shiroFilter = servletContext.addFilter("shiroFilter", DelegatingFilterProxy.class);
		Map<String, String> initParameters = new LinkedHashMap<>();
		initParameters.put("targetFilterLifecycle", "true");
		shiroFilter.setInitParameters(initParameters);
		shiroFilter.addMappingForUrlPatterns(null, false, "/*");
	}

}
