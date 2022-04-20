package com.harman.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.harman.base.WebDriverWrapper;
	
public class LoginTest extends WebDriverWrapper {
	
	//create dataprovider with name validCredentialData()
	//admin, pass, OpenEMR
	//physician, physician, OpenEMR
	
	@DataProvider
	public String[][] validCredentialData()
	{
		String[][] main = new String[2][3];
		
		main[0][0]="admin";
		main[0][1]="pass";
		main[0][2]="OpenEMR";
		
		main[1][0]="physician";
		main[1][1]="physician";
		main[1][2]="OpenEMR";
		
		return main;
	}
	
	@Test(dataProvider = "validCredentialData")
	public void validCredentialTest(String username,String password,String expectedTitle) {
		
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
