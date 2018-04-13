package group.six.controller.utils;

import org.junit.Test;

import group.six.atm.utils.CommonUtil;

public class CommonUtilTest {
	
	@Test
	public void fuzzyCardNumber() {
		System.out.println(CommonUtil.fuzzyCardNumber("6228481174357860016"));
	}
	
}
