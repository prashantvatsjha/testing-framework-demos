package com.pkj.study.TestNGDemos;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClass {

	@BeforeSuite
	public void m1() {
		System.out.println("before suit");
	}
	
	
	@AfterSuite
	public void m2() {
		System.out.println("after suit");
	}
	
	@Test
	public void m3() {
		System.out.println("Technip India m3");
	}
}
