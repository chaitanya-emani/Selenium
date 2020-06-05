package com.guru99.selenium;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileDownload {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver;
		String URL = "https://www.7-zip.org/download.html";
		String userdir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userdir+"/Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		WebElement downloadButton = driver.findElement(By.xpath("//td[contains(text(),'(alternative MSI installer) 7-Zip for 64-bit Windows x64 (Intel 64 or AMD64)')]/..//a"));
		String sourceLocation = downloadButton.getAttribute("href");
		String wgetCommandString = "cmd /c C:\\Wget\\wget.exe -P D: --no-check-certificate "+sourceLocation;
		Process process = Runtime.getRuntime().exec(wgetCommandString);
		int wait = process.waitFor();
		System.out.println(wait);
	}
}
