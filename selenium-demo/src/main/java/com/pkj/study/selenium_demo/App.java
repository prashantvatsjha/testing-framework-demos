package com.pkj.study.selenium_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Prashant Jha
 *
 */
public class App {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "C:\\soft\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();//

		driver.get("https://www.covid19india.org/");

		System.out.println("page start!");

		waitForLoad(driver);

		System.out.println("page finish!");

		Thread.sleep(3 * 1000);

		//testShowingAlertMsg(driver);
				
		testClickLnkAndScroll(driver);					
	

	}
	
	
	private static void testClickLnkAndScroll(WebDriver driver) throws InterruptedException {
		
		
		WebElement divlnk=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[1]/table/tbody[1]/tr[1]/td[1]/div"));
		divlnk.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Thread.sleep(3000);
		
		js.executeScript("arguments[0].scrollIntoView();window.scrollBy(0,-50);", divlnk);				
		
		Thread.sleep(5000);
		
		divlnk=driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[1]/table/tbody[1]/tr[344]/td[1]/div"));
		divlnk.click();
		js.executeScript("arguments[0].scrollIntoView();window.scrollBy(0,-50);", divlnk);
		
		Thread.sleep(5000);
		
		divlnk=driver.findElement(By.xpath("html/body/div/div/div/div[3]/div[1]/table/tbody[1]/tr[359]/td[1]/div"));
		divlnk.click();
		js.executeScript("arguments[0].scrollIntoView();window.scrollBy(0,-50);", divlnk);
		
		
	}

	
	private static void testShowingAlertMsg(WebDriver driver) throws InterruptedException {
		String confirmed = driver.findElement(By.xpath("//html/body/div/div/div/div[3]/div[1]/div[2]/div[1]"))
				.getText();
		String death = driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[1]/div[2]/div[4]")).getText();

		System.out.println("conf: " + confirmed);
		System.out.println("death: " + death);
		confirmed = confirmed.replaceAll("\n", "; ");
		((JavascriptExecutor) driver).executeScript("alert('" + confirmed + "')");

		Thread.sleep(3 * 1000);

		driver.switchTo().alert().accept();
		death = death.replaceAll("\n", "; ");

		System.out.println(death);

		((JavascriptExecutor) driver).executeScript("alert('" + death + "')");

		Thread.sleep(3 * 1000);

		driver.switchTo().alert().accept();
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
