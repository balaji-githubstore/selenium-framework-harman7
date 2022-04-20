package com.harman.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.harman.base.WebDriverWrapper;
	
public class LoginUITest extends WebDriverWrapper {
	
	@Test
	public void validateTitleTest()
	{
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "OpenEMR Login");
	}
	
}
