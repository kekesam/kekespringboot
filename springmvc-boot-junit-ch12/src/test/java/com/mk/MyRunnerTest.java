package com.mk;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/** 
 * @author xuke
 * @created 2017-04-30
 */
@RunWith(MyRunner.class)  
public class MyRunnerTest {  
    @BeforeClass  
    public static void beforeClass() {  
        System.out.println("执行 beforeClass");  
    }  
  
    @Before  
    public void before() {  
        System.out.println("执行 before");  
    }  
      
    @Test  
    public void should_return_something_if_age_equals_18() {  
        System.out.println("执行 should_return_something_if_age_equals_18");  
    }  
      
    @After  
    public void after() {  
        System.out.println("执行 after");  
    }  
  
    @AfterClass  
    public static void afterClass() {  
        System.out.println("执行 afterClass");  
    }  
} 