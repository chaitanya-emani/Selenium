package com.makemytrip.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchFlight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String currentDir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", currentDir+"/Resources/chromedriver.exe");
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']/div")).click();
		driver.findElement(By.xpath("//div[@class='fsw_inner ']/div[2]")).click();
	}
}
