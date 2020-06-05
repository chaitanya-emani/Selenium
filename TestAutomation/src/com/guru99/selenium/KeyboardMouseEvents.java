package com.guru99.selenium;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardMouseEvents {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		String URL = "http://www.facebook.com/";
		String userdir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userdir+"/Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		Actions keyActions = new Actions(driver);
		WebElement emailElement = driver.findElement(By.id("email"));
		keyActions.moveToElement(emailElement).click().keyDown(Keys.SHIFT).sendKeys("b.ultramagnus").keyUp(Keys.SHIFT).
		doubleClick().contextClick().build().perform();
	}
}
