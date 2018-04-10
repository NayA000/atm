package group.six.controller.utils;

import org.junit.Test;

import group.six.atm.utils.Cryptography;

public class MD5Util {
	
	@Test
	public void get() {
		// 3dc3699f08d283209840eb1423611dd7
		System.out.println(Cryptography.MD5Hash("123456", "6228481174357860016"));
	}
	
}
