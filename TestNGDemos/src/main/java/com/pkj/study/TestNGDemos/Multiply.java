package com.pkj.study.TestNGDemos;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Multiply {
	@Test
	@Parameters({ "a", "b" })
	public void mul(int c, int d) {
		int mul = c * d;
		System.out.println("Multiplication of two numbers : " + mul);
	}
}
