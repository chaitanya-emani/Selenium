package com.guru99.selenium.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeMethod_AfterMethod {
	WebDriver driver;
	@BeforeTest(alwaysRun = true)
	public void openBrowser()
	{
		String directory = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver",directory+"/Resources/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
	}
	@BeforeMethod
	public void validateHomePageTitle() {
		// TODO Auto-generated method stub
		System.out.println("validate home page title");
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
	}
	@Test
	public void validateRegister() {
		driver.findElement(By.linkText("REGISTER")).click();
		String expectedTitle = "Registration";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
	}
	@Test
	public void validateSupport() {
		driver.findElement(By.linkText("SUPPORT")).click();
		String expectedTitle = "Support";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
	}
	@BeforeGroups
	public void test1()
	{
		System.out.println("Before Groups");
	}
	@AfterGroups
	public void test2()
	{
		System.out.println("After Groups");
	}
	@BeforeClass
	public void test3()
	{
		System.out.println("Before Class");
	}
	@AfterClass
	public void test4()
	{
		System.out.println("After Class");
	}
	@AfterSuite
	public void test6()
	{
		System.out.println("After Suite");
	}
	@BeforeSuite
	public void test5()
	{
		System.out.println("Before Suite");
	}
	@AfterMethod
	public void goBackToHome()
	{
		System.out.println("go back to home page");
		driver.navigate().back();
	}
	@Test(priority = -2)
	public void validateTitle2()
	{
		
	}
	@AfterTest(alwaysRun = true)
	public void tearDown()
	{
		driver.close();
	}
}
