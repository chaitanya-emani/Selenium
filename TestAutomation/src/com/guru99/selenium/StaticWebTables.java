package com.guru99.selenium;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTables {
	public static void main(String[] args) throws InterruptedException  {
		WebDriver driver;
		String URL = "http://demo.guru99.com/test/web-table-element.php";
		String userdir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", userdir+"/Resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		List<WebElement> columnsElements = driver.findElements(By.xpath("//th"));
		List<WebElement> rowsElements = driver.findElements(By.xpath("//tr"));
		System.out.println("No of Rows: "+rowsElements.size());
		System.out.println("No of Columns: "+columnsElements.size());
		double maximumVal = 0;
		for(int row=0;row<rowsElements.size()-1;row++) //header takes one row, we are not printing header
		{
			//below code to print elements of table
			/*
			 * for(int col=0;col<columnsElements.size();col++) {
			 * System.out.print(driver.findElement(By.xpath("//tr["+(row+1)+"]/td["+(col+1)+
			 * "]")).getText()+"\t"); } System.out.println("");
			 */
			
			//below code to find max of value of a particular column
			double currentVal = Double.parseDouble(driver.findElement(By.xpath("//tr["+(row+1)+"]/td[4]")).getText());
			System.out.println(currentVal + ":"+maximumVal);
			if(currentVal > maximumVal)
				maximumVal = currentVal;
		}
		System.out.println("Maximum Val : "+maximumVal);
	}
}
