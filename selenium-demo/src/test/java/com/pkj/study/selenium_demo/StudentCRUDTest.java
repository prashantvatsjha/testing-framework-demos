package com.pkj.study.selenium_demo;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentCRUDTest {

	private static WebDriver driver;
	private String PAGE_URL = "http://localhost:4200";
	private static Random random = new Random();
	private static JavascriptExecutor js ;

	@BeforeClass
	public static void initDriver() {
		System.setProperty("webdriver.gecko.driver", "C:\\soft\\geckodriver.exe");
		driver = new FirefoxDriver();
		js= (JavascriptExecutor) driver;
	}

	@Test
	public void secondTestViewStudents() throws InterruptedException {
					
		driver.get("http://localhost:4200");
		waitForLoad(driver);
		assertTrue(driver.getTitle().equals("FormSubmit"));
		Thread.sleep(5000);				
		
		String jsCode="var h2Node = document.createElement('h2'); h2Node.setAttribute('id','h2NodeId'); h2Node.setAttribute('style','color:red'); var divTitle=document.evaluate('/html/body/app-root/div/app-student-list/div[1]/div[1]',document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue; divTitle.appendChild(h2Node);document.getElementById('h2NodeId').innerHTML='Starting Testing...'";

		js.executeScript(jsCode);
		Thread.sleep(10000);
		
		js.executeScript("document.getElementById('h2NodeId').innerHTML='Testing pagination...'");
		
		Thread.sleep(3000);
		js.executeScript("document.getElementById('h2NodeId').innerHTML='Testing pagination next page...'");
		
		WebElement nextLnk=driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0_next\"]"));
		nextLnk.click();
		Thread.sleep(3000);
		js.executeScript("document.getElementById('h2NodeId').innerHTML='Testing pagination prev page...'");
		
		WebElement prevLnk=driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0_previous\"]"));
		prevLnk.click();
		Thread.sleep(3000);
		
		js.executeScript("document.getElementById('h2NodeId').innerHTML='Testing search...'");
		Thread.sleep(3000);
		
		WebElement txtSearch=driver.findElement(By.xpath("/html/body/app-root/div/app-student-list/div[1]/div[2]/div/div[2]/label/input"));
		txtSearch.sendKeys("d");
		Thread.sleep(5000);
		txtSearch.clear();
		txtSearch.sendKeys("do");
		
		Thread.sleep(5000);
		txtSearch.clear();
		txtSearch.sendKeys("pras");
		
		Thread.sleep(3000);
		
		js.executeScript("document.getElementById('h2NodeId').innerHTML='Testing update...'");
		Thread.sleep(3000);
		
		WebElement butUpdate=driver.findElement(By.xpath("/html/body/app-root/div/app-student-list/div[1]/div[2]/div/table/tbody/tr[1]/td[4]/button[2]"));
				
		Thread.sleep(3000);
		butUpdate.click();
		
		
		WebElement name=driver.findElement(By.xpath("/html/body/app-root/div/app-student-list/div[2]/div/div/form/div[2]/div[1]/div[1]/input"));
		
		Thread.sleep(3000);
		name.clear();
		Thread.sleep(3000);
		
		name.sendKeys("Prashant kumar Jha");
		
		Thread.sleep(3000);
		
	
		
		WebElement btnUpdate=driver.findElement(By.xpath("/html/body/app-root/div/app-student-list/div[2]/div/div/form/div[3]/button[1]"));
		
		btnUpdate.click();
		
		Thread.sleep(500);
		
		WebElement msg=driver.findElement(By.xpath("/html/body/app-root/div/app-student-list/div[2]/div/div/form/div[2]/div[2]/h4"));
		assertTrue(msg.getText().indexOf("Student Detail Updated!")>=0);
		
		
		driver.findElement(By.xpath("/html/body/app-root/div/app-student-list/div[2]/div/div/form/div[3]/button[2]")).click();
		
		js.executeScript("document.getElementById('h2NodeId').innerHTML='Testing update completed!'");
		Thread.sleep(3000);
		
		
	}
	
	//@Test
	public void firstTestAddStudent() throws InterruptedException {

		driver.get(PAGE_URL);
		waitForLoad(driver);
		assertTrue(driver.getTitle().equals("FormSubmit"));

		Thread.sleep(5000);
		
		WebElement addLnk = driver.findElement(By.linkText("Add Student"));
		addLnk.click();	

		Thread.sleep(5000);
		
		// check for correct page
		WebElement addPageHead = driver.findElement(By.xpath("/html/body/app-root/div/app-add-student/h3"));

		assertTrue(addPageHead.getText().equals("Create Student"));

		WebElement name = driver
				.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/div[1]/input"));
		name.sendKeys("Prashant Jha");

		WebElement email = driver
				.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/div[2]/input"));
		email.sendKeys("prashant.jha_" + random.nextInt(100) + "@gmail.com");

		WebElement branch = driver
				.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/div[3]/select"));

		Select dropdown = new Select(branch);

		dropdown.selectByVisibleText("MCA");

		Thread.sleep(3000);

		WebElement submit = driver
				.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/button"));

		Thread.sleep(3000);

		submit.click();

		Thread.sleep(3000);

		WebElement actionMsg = driver
				.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[2]/div[2]/div/h4"));

		assertTrue(actionMsg.getText().equals("Student Added SuccessFully!"));

		 WebElement addMore=driver.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[2]/div[2]/div/button"));

		 addMore.click();

		System.out.println("test");		
		
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
