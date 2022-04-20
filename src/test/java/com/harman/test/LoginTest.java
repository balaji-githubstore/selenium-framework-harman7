package com.harman.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demo.openemr.io/b/openemr");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test
	public void validCredentialTest() {
		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.cssSelector("#clearPass")).sendKeys("pass");
		driver.findElement(By.id("login-button")).click();

		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "OpenEMR");
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
