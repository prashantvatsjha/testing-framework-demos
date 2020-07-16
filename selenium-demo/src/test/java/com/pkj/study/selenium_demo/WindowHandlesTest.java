package com.pkj.study.selenium_demo;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Set;
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

public class WindowHandlesTest {

	private static WebDriver driver;
	private String PAGE_URL = "http://localhost:8080";

	@BeforeClass
	public static void initDriver() {
		System.setProperty("webdriver.gecko.driver", "C:\\soft\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Test
	public void testWinHandles() throws InterruptedException {

		driver.get(PAGE_URL);

		WebDriverWait wait = new WebDriverWait(driver, 15);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/form/input[3]")));
		System.out.println("got submit button!");

		driver.findElement(By.xpath("/html/body/div/div/form/input[3]")).click();
		System.out.println("after");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		String currentPage = driver.getWindowHandle();
		System.out.println("Cur page 1: " + currentPage + ", cur url: " + driver.getCurrentUrl() + ", cur title: "
				+ driver.getTitle());
		String firstWin = currentPage;

		driver.findElement(By.linkText("View Users")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		currentPage = driver.getWindowHandle();
		System.out.println("Cur page 2: " + currentPage + ", cur url: " + driver.getCurrentUrl() + ", cur title: "
				+ driver.getTitle());

		Set<String> windows = driver.getWindowHandles();

		for (String str : windows) {

			if (!str.equals(currentPage)) {
				driver.switchTo().window(str);
				System.out.println("focus switched to => " + str);
				break;
			}
		}
		
		currentPage = driver.getWindowHandle();
		Thread.sleep(15*1000);
		
		System.out.println("Cur page 3: " + currentPage + ", cur url: " + driver.getCurrentUrl() + ", cur title: "
				+ driver.getTitle());

		System.out.println("switching to firts windows...");

		driver.switchTo().window(firstWin);

		System.out.println("switched!");

		currentPage = driver.getWindowHandle();
		System.out.println("Cur page 4: " + currentPage + ", cur url: " + driver.getCurrentUrl() + ", cur title: "
				+ driver.getTitle());

	//	driver.close();

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
