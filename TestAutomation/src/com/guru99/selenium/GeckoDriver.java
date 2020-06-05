package com.guru99.selenium;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GeckoDriver {
	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException  {	    
		WebDriver driver;
		String URL = "http://www.zlti.com/";
		String userdir = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", userdir+"/Resources/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
	}
}
