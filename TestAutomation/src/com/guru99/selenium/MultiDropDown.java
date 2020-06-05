package com.guru99.selenium;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MultiDropDown {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		String URL = "http://output.jsbin.com/osebed/2";
		String userdir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userdir+"/Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		Actions scroll = new Actions(driver);
		WebElement fruitSelect = driver.findElement(By.cssSelector("select#fruits"));
		scroll.moveToElement(fruitSelect);
		Select country = new Select(fruitSelect);
		System.out.println("is multiple? " + country.isMultiple());
		country.selectByIndex(2);
		Thread.sleep(2000);
		country.selectByValue("banana");
		Thread.sleep(2000);
		country.selectByVisibleText("Grape");
		Thread.sleep(2000);
		country.deselectByVisibleText("Grape");
		Thread.sleep(2000);
		country.deselectByValue("banana");
		Thread.sleep(2000);
		country.deselectAll();
		Thread.sleep(2000);
		country.selectByValue("orange");
		Thread.sleep(2000);
		country.selectByValue("banana");
		Thread.sleep(2000);
		country.selectByVisibleText("Grape");
		Thread.sleep(2000);
		List<WebElement> selectedOptionsList = country.getAllSelectedOptions();
		for(WebElement webElement : selectedOptionsList)
			System.out.println(webElement.getText());
		}
}
