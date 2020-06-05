package com.guru99.selenium;


import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleTabs {
	public static void main(String[] args) throws InterruptedException  {
		WebDriver driver;
		String URL = "http://demo.guru99.com/popup.php";
		String userdir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userdir+"/Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		String mainWindow = driver.getWindowHandle();
		driver.findElement(By.linkText("Click Here")).click();
		Thread.sleep(2000);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.toString());
			String childWindow = iterator.next();
			if(!mainWindow.equalsIgnoreCase(childWindow))
			{
				driver.switchTo().window(childWindow);
				driver.findElement(By.name("emailid")).sendKeys("asdasd@asd.asd");
				driver.findElement(By.name("btnLogin")).click();
				Thread.sleep(2000);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		driver.close();
	}
}
