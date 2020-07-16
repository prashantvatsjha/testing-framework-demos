package com.pkj.study.TestNGDemos;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	
	@Test(dataProvider="dataProviderForSquare")
	public void testSquare(int num) {
		System.out.println("************Square***********");
		System.out.println(num*num);
	}
	
	@Test(dataProvider="dataProviderForAdd")
	public void testAdd(int a,int b) {
		System.out.println("************Add***********");
		System.out.println(a+b);
	}
	
	@Test(dataProvider="dataProviderForAddFromExcel",dataProviderClass= DataProviderClass.class)
	public void testMull(int a,int b) {
		System.out.println("************Muull from excel***********");
		System.out.println(a*b);
	}
	
	@DataProvider(name="dataProviderForSquare")
	public Object[][] dataProviderForSquare() {
		
		return new Object[][] {{1},{2},{3},{4},{5}};
	}
	
	
	@DataProvider(name="dataProviderForAdd")
	public Object[][] dataProviderForAdd() {		
		return new Object[][] {{1,2},{2,4},{3,5},{4,6},{5,7}};
	}
	
}
