package com.pkj.study.TestNGDemos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class Fruits {

	public static void main(String args[]) {
		List<String> strList=Arrays.asList("D_mango","B_apple","C_watermelon");
		System.out.println(strList);
		Collections.sort(strList);
		System.out.println(strList);
	}
	
	@Test(priority=-500)
	public void D_mango() {
		System.out.println("I am Mango");
	}

	@Test(priority = 2)	
	public void B_apple() {
		System.out.println("I am Apple");
	}

	@Test(priority = -600)	
	public void C_watermelon() {
		System.out.println("I am Watermelon");
	}
	
	

}
