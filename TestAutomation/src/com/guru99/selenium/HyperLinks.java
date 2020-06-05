package com.guru99.selenium;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HyperLinks {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		//String URL = "http://demo.guru99.com/test/link.html";
		//String URL = "http://demo.guru99.com/test/accessing-link.html";
		//String URL = "http://newtours.demoaut.com/mercurysignon.php";
		String URL = "http://demo.guru99.com/test/block.html";
		String userdir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userdir+"/Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		/*
		 * driver.findElement(By.linkText("click here")).click();
		 * driver.navigate().back();
		 * driver.findElement(By.partialLinkText("here")).click();
		 * driver.navigate().back(); driver.findElement(By.xpath("//a[2]")).click();
		 */
		
		/*
		 * driver.findElement(By.partialLinkText("go")).click(); Thread.sleep(3000);
		 * System.out.println(driver.getTitle()); driver.navigate().back();
		 * driver.findElement(By.partialLinkText("click")).click(); Thread.sleep(3000);
		 * System.out.println(driver.getTitle());
		 */
		
		/*
		 * driver.findElement(By.partialLinkText("EGIST")).click();;
		 * System.out.println(driver.getCurrentUrl().toString());
		 * driver.navigate().back();
		 * driver.findElement(By.partialLinkText("egist")).click();
		 * System.out.println(driver.getCurrentUrl().toString());
		 */
		
		/*
		 * driver.findElement(By.partialLinkText("Inside")).click();
		 * driver.navigate().back();
		 * driver.findElement(By.partialLinkText("Outside")).click();
		 * driver.navigate().back();
		 */
		
		List<WebElement> anchorTags = driver.findElements(By.tagName("a"));
		for(WebElement webElement : anchorTags)
			System.out.println(webElement.getAttribute("href"));
	}
}
