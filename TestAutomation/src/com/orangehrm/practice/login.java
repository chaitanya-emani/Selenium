package com.orangehrm.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class login {
	WebDriver driver=null;
	String URL = "https://opensource-demo.orangehrmlive.com/";
	
	@BeforeTest
	public void setup()
	{
		String userdir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userdir+"/Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
	}
	@Test
	public void loginTest()
	{
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	@AfterTest
	public void tearDown()
	{
		//driver.quit();
	}
}
