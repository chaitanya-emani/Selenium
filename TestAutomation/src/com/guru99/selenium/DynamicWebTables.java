package com.guru99.selenium;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTables {
	public static void main(String[] args) throws InterruptedException  {
		WebDriver driver;
		String URL = "http://demo.guru99.com/test/table.html";
		List<WebElement> columnsElements;
		String userdir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userdir+"/Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		List<WebElement> rowsElements = driver.findElements(By.xpath("//tr"));
		for(int row=1;row<=rowsElements.size();row++)
		{
			columnsElements = driver.findElements(By.xpath("//tr["+row+"]/td"));
			for(int col=1;col<=columnsElements.size();col++)
			{
				System.out.print(driver.findElement(By.xpath("//tr["+row+"]/td["+col+"]")).getText());
			}
			System.out.println("");
		}
	}
}
