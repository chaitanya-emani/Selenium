package com.guru99.selenium;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SimpleToolTip {
	public static void main(String[] args) throws InterruptedException  {
		WebDriver driver;
		String URL = "http://demo.guru99.com/test/social-icon.html";
		String userdir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userdir+"/Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		Actions action = new Actions(driver);
		List<WebElement> icons = driver.findElements(By.xpath("//div[@id='top-bar']//a"));
		for(WebElement iElement : icons)
		{
			System.out.println(iElement.getAttribute("title"));
			action.moveToElement(iElement).build().perform();
			Thread.sleep(2000);
		}
		
	}
}
