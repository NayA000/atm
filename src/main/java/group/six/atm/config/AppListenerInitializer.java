package group.six.atm.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

/**
 * 注册监听器
 * @author Hayate
 *
 */
public class AppListenerInitializer  implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// 配置logback
//		servletContext.setInitParameter("logbackConfigLocation", "classpath:logback.xml");
//		servletContext.addListener(ch.qos.logback.ext.spring.web.LogbackConfigListener.class);
	}

}
