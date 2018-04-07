package group.six.controller.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import group.six.atm.config.RootConfig;
import group.six.atm.config.WebConfig;
import group.six.atm.dao.UserMapper;
import group.six.atm.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {WebConfig.class, RootConfig.class})
@WebAppConfiguration
public class UserTest {
	
	@Autowired
	private UserMapper userMapper;
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Test
	public void testSelectByPrimaryKey() {
		User u = userMapper.selectByPrimaryKey(1L);
		System.err.println(u);
		System.err.println(u.getCard());
	}
	
}
