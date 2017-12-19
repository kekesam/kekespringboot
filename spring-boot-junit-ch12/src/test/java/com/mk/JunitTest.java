package com.mk;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitTest {
	
	@BeforeClass
	public static void beforeClassTest() {
		System.out.println("1：@BeforeClass*******************************************");
		System.out.println("1：@BeforeClass单元测试开始之前初始化操作....");
		System.out.println("1：@BeforeClass*******************************************\n");
	}
	
	@Before//每个测试用例都会执行一次
	public void beforeTest() {
		System.out.println("2：@Before单元测试开始之前初始化操作....");
	}
	
	@Test
	public void test() {
		System.out.println("@Test====================1：单元测试逻辑================");
	}
	
	@Test
	public void test2() {
		System.out.println("@Test====================2：单元测试逻辑================");
	}
	
	@Test
	public void test3() {
		System.out.println("@Test====================3：单元测试逻辑================");
	}
	
	@After//=====每个测试用例执行完毕都会执行一次。
	public void afterTest() {
		System.out.println("3：@After单元测试开始之后操作....");
		System.out.println("\n");
	}
	
	@AfterClass //需要等所有的测试用例才执行，
	public static void afterClassTest() {
		System.out.println("4：@AfterClass*******************************************");
		System.out.println("4：@AfterClass单元测试开始之后操作....");
		System.out.println("4：@AfterClass*******************************************");
	}
}
