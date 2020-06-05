package com.guru99.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		String URL = "http://demo.guru99.com/test/ajax.html";
		String userdir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userdir+"/Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		Thread.sleep(5000);
		List<WebElement> radiosElements = driver.findElements(By.name("name"));
		List<WebElement> anchorList = driver.findElements(By.xpath("//li[@class='dropdown']/a"));
		for(WebElement radiosElement : radiosElements)
		{
			System.out.println(radiosElement.getAttribute("id"));
		}
		for(WebElement a:anchorList)
		{
			System.out.println(a.getAttribute("href"));
		}
		//driver.findElement(By.xpath("//li[@class='dropdown']/a[contains(text(),'Insurance')]")).click();
		driver.findElement(By.xpath("//li[@class='dropdown']/a")).click();
	}
}
