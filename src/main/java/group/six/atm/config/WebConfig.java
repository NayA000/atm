package group.six.atm.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * SpringMVC配置
 * @author Hayate
 *
 */
@Configuration
@EnableWebMvc  // 启用注解驱动的SpringMVC，等价于 <mvc:annotation-driven />
@ComponentScan(basePackages= {"group.six.atm.controller"}) // 扫描Controller
public class WebConfig extends WebMvcConfigurerAdapter {
	
	/**
	 * 配置视图解析器
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".html");
		//resolver.setViewClass(JstlView.class); // 返回jstl视图
		resolver.setExposeContextBeansAsAttributes(true); // 设置是否把所有在上下文中定义的bean作为request属性可公开访问。
		return resolver;
	}
	
	/**
	 * 注册拦截器
	 */
   /* @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInteceptor()).addPathPatterns("/*");
	}*/

	/**
	 * 配置对静态资源的处理
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	/**
	 * 配置JSON转换
	 */
	@Bean
	public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		return converter;
	}
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(fastJsonHttpMessageConverter());
		super.configureMessageConverters(converters);
	}
	
	/**
	 * 解决跨域访问 No 'Access-Control-Allow-Origin' header问题
	 * @return
	 */
//	@Bean
//    public WebMvcConfigurerAdapter corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/*").allowedOrigins("*");
//            }
//        };
//    }
}
