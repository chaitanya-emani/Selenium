package com.guru99.selenium;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		String URL = "http://demo.guru99.com/test/newtours/register.php";
		String userdir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userdir+"/Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		Actions scroll = new Actions(driver);
		WebElement countrySelect = driver.findElement(By.name("country"));
		scroll.moveToElement(countrySelect);
		Select country = new Select(countrySelect);
		Thread.sleep(5000);
		/*
		 * country.selectByIndex(2); Thread.sleep(2000);
		 * country.selectByValue("ALGERIA"); Thread.sleep(2000);
		 * country.selectByVisibleText("INDIA"); Thread.sleep(2000);
		 * country.deselectByVisibleText("INDIA"); Thread.sleep(2000);
		 * country.deselectByValue("AMERICAN SAMOA");
		 */
		List<WebElement> countriesList = country.getOptions();
		for(WebElement countryElement : countriesList)
		{
			System.out.println(countryElement.getText());
		}
		}
}
