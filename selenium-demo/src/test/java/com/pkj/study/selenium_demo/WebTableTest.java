package com.pkj.study.selenium_demo;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTableTest {

	
	private static WebDriver driver;
	private String PAGE_URL="http://demo.guru99.com/test/web-table-element.php";
	
	
	@BeforeClass
	public  static void initDriver() {
		System.setProperty("webdriver.gecko.driver", "C:\\soft\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void testTable() throws InterruptedException, IOException {				
		driver.get(PAGE_URL);
		
		
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		assertTrue(driver.getTitle().equals("Web Table Elements"));	
		
		//explicit wait, will wait for certain element or condition like element visibility
		WebDriverWait wait=new WebDriverWait(driver, 10);
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[3]/div[1]/table")));
		
		 TakesScreenshot scrShot =((TakesScreenshot)driver);
		 		
		 File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		 
		 FileUtils.copyFile(SrcFile, new File("table.png"));
		driver.manage().window().maximize();		
		WebElement table=driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/table"));
		
		List<WebElement> trList=table.findElements(By.tagName("tr"));
		
		
		
		System.out.println(trList);
		
		for(WebElement tr:trList) {
			List<WebElement> tdList=tr.findElements(By.tagName("td"));
			
			for(WebElement td: tdList) {
				System.out.print(td.getText()+"=> ");
			}
			System.out.println("");
		}
		
		
		driver.close();
		
	}

	
	public static void waitForLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
	}
	
	
}
