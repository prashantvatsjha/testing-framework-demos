package com.pkj.study.TestNGDemos;

import org.testng.annotations.Test;

public class DependsOnMethods {

	@Test(description="this is web login test")
	public void WebStudentLogin() {
		System.out.println("Student login through web");
	}

	@Test
	public void MobileStudentLogin() {
		System.out.println("Student login through mobile");
	}

	@Test(dependsOnMethods = { "WebStudentLogin","MobileStudentLogin" })
	public void APIStudentLogin() {
		System.out.println("Student login through API");
	}
}
