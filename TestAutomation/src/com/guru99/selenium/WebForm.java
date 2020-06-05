package com.guru99.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebForm {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		String URL = "http://demo.guru99.com/test/login.html";
		String userdir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userdir+"/Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		WebElement email = driver.findElement(By.cssSelector("input#email"));
		WebElement password = driver.findElement(By.cssSelector("input#passwd"));
		Thread.sleep(5000);
		email.sendKeys("asd");
		password.sendKeys("asdf");
		Thread.sleep(3000);
		email.clear();
		password.clear();
		Thread.sleep(3000);
		email.sendKeys("email");
		password.sendKeys("passwd");
		//driver.findElement(By.cssSelector("button#SubmitLogin")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.cssSelector("button#SubmitLogin")).submit();
		//Thread.sleep(3000);
		password.submit();
		
	}
}
