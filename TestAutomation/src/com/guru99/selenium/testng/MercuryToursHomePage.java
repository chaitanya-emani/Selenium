package com.guru99.selenium.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MercuryToursHomePage {
	WebDriver driver;
	@BeforeTest
	public void openBrowser()
	{
		String directory = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver",directory+"/Resources/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
	}
	@Test(priority = 1)
	public void validateTitle()
	{
		System.out.println("validate title 1 ");
		String expectedTitle = "Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
	}
	@Test(priority = -2)
	public void validateTitle2()
	{
		System.out.println("validate title 2");
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
	}
	@AfterTest(alwaysRun = true)
	public void tearDown()
	{
		driver.close();
	}
}
