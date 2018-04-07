package group.six.atm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import group.six.atm.dao.ATMMapper;


@RestController
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private ATMMapper ATMMapper;
	
	public void setATMMapper(ATMMapper aTMMapper) {
		ATMMapper = aTMMapper;
	}
	
	@RequestMapping("/test")
	public void testConfig() {
		logger.info("访问测试链接");
		System.err.println(ATMMapper.selectByPrimaryKey(1L));
	}
}
