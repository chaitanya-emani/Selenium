package com.guru99.selenium;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException  {	    
		WebDriver driver;
		String URL = "http://www.zlti.com/";
		String userdir = System.getProperty("user.dir");
		HttpURLConnection huc;
		System.setProperty("webdriver.chrome.driver", userdir+"/Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//aside[@id='cookie-policy-wrap']//button")).click();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(WebElement link : links)
		{
			System.out.println("Connecting to : "+link.getAttribute("href"));
			huc = (HttpURLConnection)(new java.net.URL(link.getAttribute("href")).openConnection());
			huc.setRequestMethod("HEAD");
			huc.connect();
			if(huc.getResponseCode() != 200)
				System.out.println("Broken");
			else System.out.println("Working");
		}
	}
}
