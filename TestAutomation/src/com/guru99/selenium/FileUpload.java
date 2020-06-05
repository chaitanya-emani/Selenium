package com.guru99.selenium;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		String URL = "http://demo.guru99.com/test/upload/";
		String userdir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userdir+"/Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		//Actions keyActions = new Actions(driver);
		WebElement filElement = driver.findElement(By.cssSelector("input#uploadfile_0"));
		filElement.sendKeys("C:\\Users\\Chaitanya Emani\\Downloads\\200+ Selenium Interview Questions .docx");
		System.out.println(driver.findElement(By.cssSelector("input#terms")).isSelected());
		driver.findElement(By.id("submitbutton")).click();;
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#terms")).click();
		System.out.println(driver.findElement(By.cssSelector("input#terms")).isSelected());
		driver.findElement(By.id("submitbutton")).click();
	}
}
