package com.pkj.study.selenium_demo;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Driver;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyTest {
	static WebDriver driver;
	
	@BeforeClass
	public static void initDriver() {
		System.setProperty("webdriver.gecko.driver", "C:\\soft\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	
	@Test
	public void testTabsWindow() throws AWTException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Navigating to airbnb         

        driver.get("https://www.airbnb.co.in/");

        driver.manage().window().maximize();

        String currentHandle = driver.getWindowHandle();

        //locating the location, looking for homestays         

        driver.findElement(By.id("Koan-magic-carpet-koan-search-bar__input")).sendKeys("Goa", Keys.ENTER);

        //Clicking on search button         

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String urlToClick = driver.findElement(By.xpath("//div[text()='Luxury Three Bedroom Apartment with Pool & Jacuzzi']/ancestor::a")).getAttribute("href"); //opening the new tab         

        Robot r = new Robot();

        r.keyPress(KeyEvent.VK_CONTROL);

        r.keyPress(KeyEvent.VK_T);

        r.keyRelease(KeyEvent.VK_CONTROL);

        r.keyRelease(KeyEvent.VK_T); //getting all the handles currently available         

        Set < String > handles = driver.getWindowHandles();

        for (String actual: handles) {

            if (!actual.equalsIgnoreCase(currentHandle)) { //switching to the opened tab              

                driver.switchTo().window(actual); //opening the URL saved.              

                driver.get(urlToClick);

            }

        }
		
	}
	
	//@Test
	public void testFrames() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/guru99home/");
		waitForLoad(driver);
		 driver.manage().window().maximize();
		/* driver.switchTo().frame("a077aa5e");
		 ///html/body/a/img
		 
		 WebElement linkInsideFrame=driver.findElement(By.xpath("/html/body"));
		 System.out.println(linkInsideFrame.getText());
		 System.out.println("*********We are done***************");*/
		 
		 int size = driver.findElements(By.tagName("iframe")).size();
		 System.out.println("frame size: "+size);
		 for(int i=0; i<=size; i++){
				driver.switchTo().frame(i);
				int total=driver.findElements(By.xpath("/html/body/a/img")).size();
				System.out.println(total);
				    driver.switchTo().defaultContent();
				    
		 }
		 		 
		
	}
	

	// @Test
	public void openWebPage() {
		
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		assertTrue(driver.getTitle().equals("Google"));
		driver.close(); // will close tab
	}

	// @Test
	public void testLoginFailed() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.cisssalesforce.com/");
		driver.findElement(By.id("name")).sendKeys("sunil1231");
		driver.findElement(By.id("password")).sendKeys("pass@123");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(3000);
		String error = driver.findElement(By.className("alert-warning")).getText();
		assertTrue(error.equals("wrong username or password"));
	}

	// @Test
	public void testLoginSuccess() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.cisssalesforce.com/");

		driver.findElement(By.id("name")).sendKeys("sunil123");
		driver.findElement(By.id("password")).sendKeys("pass@123");

		driver.findElement(By.cssSelector("button[type='submit']")).click();

		Thread.sleep(3000);

		int size = driver.findElements(By.cssSelector("ul a:(first-child)")).size();
		System.out.println("size: " + size);
		assertTrue(size == 3);

		String welcomMsg = driver.findElement(By.xpath("your xpath")).getText();
		welcomMsg = welcomMsg.trim();
		System.out.println(welcomMsg);
		assertTrue(welcomMsg.startsWith("Welcome"));

		driver.findElement(By.className("your classname"));

	}

	//@Test
	public void testWebTable() {

		WebDriver driver;

		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/test/web-table-element.php");

		WebElement base = driver.findElement(By.className("Table"));
		List<WebElement> tableRows = base.findElements(By.tagName("tr"));
		List<WebElement> tableCols = tableRows.get(2).findElements(By.tagName("td"));
		String cellValue = tableCols.get(1).getText();
		System.out.println(cellValue);
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
