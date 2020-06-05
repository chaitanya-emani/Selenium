package com.guru99.selenium;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HTMLTables {
	public static void main(String[] args) throws InterruptedException  {
		WebDriver driver;
		String URL = "http://demo.guru99.com/test/write-xpath-table.html";
		String userdir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userdir+"/Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		List<WebElement> dataList = driver.findElements(By.xpath("//td"));
		for(WebElement w:dataList)
			System.out.println(w.getText());
		System.out.println(driver.findElement(By.xpath("//tr[2]/td[2]")).getText());
		driver.quit();
		driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/accessing-nested-table.html");
		System.out.println(driver.findElement(By.xpath("//tr[2]/td[2]//following::td[4]")).getText());
		driver.quit();
		driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		System.out.println(driver.findElement(By.xpath("//table[@width='270']/tbody/tr[3]/td")).getText());
	}
}
