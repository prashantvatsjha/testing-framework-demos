package com.pkj.study.selenium_demo;

import java.util.concurrent.TimeUnit;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {

	private static WebDriver driver;

	@BeforeClass
	public static void initDriver() {
		System.setProperty("webdriver.gecko.driver", "C:\\soft\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Test
	public void testWinHandles() throws InterruptedException {

		driver.get("http://demo.guru99.com/test/drag_drop.html");
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(30*1000);
		WebElement from =driver.findElement(By.xpath("/html/body/section/div/div/main/div/div/div/div/div/div/div[1]/div/ul/li[5]/a"));
		
		WebElement to=driver.findElement(By.xpath("/html/body/section/div/div/main/div/div/div/div/div/div/table/tbody/tr/td[1]/table/tbody/tr/td[1]/div/div/ol/li"));
		
		Actions act=new Actions(driver);
		act.dragAndDrop(from, to);
		
		
		System.out.println("done!");
		
		
	//	driver.close();

	}

	//@Test
	public void testFrame() {
		//iframeResult
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml5_draganddrop");
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.switchTo().frame("iframeResult");
		
		WebElement from =driver.findElement(By.xpath("//*[@id=\"drag1\"]"));
		
		WebElement to=driver.findElement(By.xpath("//*[@id=\"div1\"]"));
		
		Actions act=new Actions(driver);
		act.dragAndDrop(from, to);
		System.out.println("done!");
		
		
	}
	
	
	
}
