package com.harman.test;

import org.testng.annotations.Test;

public class LoginTest {
	
	@Test(invocationCount = 3)
	public void validCredentialTest()
	{
		System.out.println("valid");
	}

}
