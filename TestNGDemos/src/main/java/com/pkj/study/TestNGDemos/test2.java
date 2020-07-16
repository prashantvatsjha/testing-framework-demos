package com.pkj.study.TestNGDemos;

import org.testng.annotations.Test;

public class test2 {

	@Test(enabled=false)
	public void m1() {
		System.out.println("TestNG[test2][m1] is working fine!");
		
	}

	@Test
	public void m2() {
		System.out.println("TestNG[test2][m2] is working fine!");
		
	}
	
	@Test
	public void m3() {
		System.out.println("TestNG[test2][m3] is working fine!");
		
	}
	
}
