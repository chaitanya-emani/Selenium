package com.guru99.selenium;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver;
		String URL = "http://demo.guru99.com/test/delete_customer.php";
		String userdir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userdir+"/Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		Thread.sleep(3000);
		driver.findElement(By.name("cusid")).sendKeys("123");
		driver.findElement(By.name("submit")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
	}
}
