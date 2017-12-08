package com.mk;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({JunitTest.class,JunitTest2.class})
public class SuiteClass {
	
	//这里并不需要写任何其他代码，也可以运行JunitTest.class,JunitTest2.class相关测试单元。
}
