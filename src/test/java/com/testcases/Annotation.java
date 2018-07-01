package com.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotation {
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Calling before suite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Calling before test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Calling before calss");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Calling before method");
	}
	
	@Test
	public void testA() {
		System.out.println("Test A running");
	}

	@Test
	public void testB() {
		System.out.println("Test B running");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Calling after method");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Calling after class");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Calling after test");
		}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("Calling after suite");
	}
	
}
