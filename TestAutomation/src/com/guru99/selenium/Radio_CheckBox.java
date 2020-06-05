package com.guru99.selenium;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radio_CheckBox {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		String URL = "http://demo.guru99.com/test/radio.html";
		String userdir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userdir+"/Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		List<WebElement> radioList = driver.findElements(By.cssSelector("input[name='webform'][type='radio']"));
		List<WebElement> checkboxList = driver.findElements(By.cssSelector("input[name='webform'][type='checkbox']"));
		for(WebElement radioElement : radioList)
		{
			radioElement.click();
			Thread.sleep(3000);
			System.out.println(radioElement.getAttribute("id") + " : is clicked");
		}
		for(WebElement checkbox : checkboxList)
		{
			checkbox.click();
			Thread.sleep(3000);
			System.out.println(checkbox.getAttribute("id")+" : is selected");
			System.out.println(checkbox.isSelected() +" : isSelected?");
			checkbox.click();
			Thread.sleep(3000);
			System.out.println(checkbox.getAttribute("id")+" : is de-selected");
			System.out.println(checkbox.isSelected() +" : isSelected?");
		}
	}
}
