package group.six.controller.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import group.six.atm.config.RootConfig;
import group.six.atm.config.WebConfig;
import group.six.atm.dao.ATMMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {WebConfig.class, RootConfig.class})
@WebAppConfiguration
public class ATM_Test {
	
	@Autowired
	private ATMMapper ATMMapper;
	
	public void setATMMapper(ATMMapper aTMMapper) {
		ATMMapper = aTMMapper;
	}

	@Test
	public void testSelectByPrimaryKey() {
		System.err.println(ATMMapper.selectByPrimaryKey(1L));
	}
}
