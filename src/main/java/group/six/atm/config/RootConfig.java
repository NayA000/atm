package group.six.atm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Spring配置
 * @author Hayate
 *
 */
@Configuration
@ImportResource(locations = {"classpath*:applicationContext.xml"}) // 引入配置文件
@Import(value = {ShiroConfig.class}) // 引入配置类
@EnableTransactionManagement // 开启事务管理
@EnableAspectJAutoProxy // 配置切面
@ComponentScan(basePackages = { "com.bsp.dao.impl", "com.bsp.service.impl", "com.bsp.web.interceptor" }, excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
public class RootConfig {
	
	
	
	
}
