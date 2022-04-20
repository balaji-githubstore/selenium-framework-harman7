package com.harman.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.harman.base.WebDriverWrapper;
import com.harman.utilities.DataUtils;

public class LoginTest extends WebDriverWrapper {
	//will start at 9:20 PM IST
	@Test(dataProviderClass = DataUtils.class,dataProvider = "validCredentialData")
	public void validCredentialTest(String username, String password, String expectedTitle) {

		driver.findElement(By.id("authUser")).sendKeys(username);
		driver.findElement(By.cssSelector("#clearPass")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();

		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public void invalidCredentialTest() {
		driver.findElement(By.id("authUser")).sendKeys("john");
		driver.findElement(By.cssSelector("#clearPass")).sendKeys("john123");
		driver.findElement(By.id("login-button")).click();

		String actualError = driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).getText();
		Assert.assertEquals(actualError, "Invalid username or password");
	}

}
