package group.six.atm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import group.six.atm.dto.Result;
import group.six.atm.shiro.ShiroUtils;


@RestController
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping("/test")
	public Result testConfig() {
		logger.info(ShiroUtils.getSession().getId()+": 访问测试链接");
		System.err.println(ShiroUtils.getToken().getAccount());
		return Result.success("测试成功");
	}
}
