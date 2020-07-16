package com.pkj.study.TestNGDemos;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Subtract {
	@Test
	@Parameters({ "a", "b" })
	public void sub(int c, int d) {
		int subtract = c - d;
		System.out.println("Subtraction of two numbers : " + subtract);
	}
}
