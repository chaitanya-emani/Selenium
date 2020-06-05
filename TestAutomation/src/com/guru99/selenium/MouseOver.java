package com.guru99.selenium;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOver {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		String URL = "http://demo.guru99.com/test/newtours/";
		String userdir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userdir+"/Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		Actions moveMouse = new Actions(driver);
		List<WebElement> cellsElements = driver.findElements(By.xpath("//tr[@class='mouseOut']"));
		for(WebElement cellElement : cellsElements)
		{
			System.out.println("before hover colour :"+cellElement.getCssValue("background-color"));
			moveMouse.moveToElement(cellElement).build().perform();
			System.out.println("after hover colour :"+cellElement.getCssValue("background-color"));
			Thread.sleep(3000);
		}
	}
}
