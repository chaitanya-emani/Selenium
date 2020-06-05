package com.guru99.selenium;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImageClick {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		String URL = "https://www.facebook.com/login/identify";
		String userdir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userdir+"/Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		driver.findElement(By.cssSelector("a[title='Go to Facebook home']")).click();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
			}
}
