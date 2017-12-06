package com.mk;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.mk.web.UserController;

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest
@WebAppConfiguration 
public class WebControllerTest {

	private MockMvc mockMvc;
	
	@Autowired  
    private UserController controller;  
	  
    @Before  
    public void setUp() throws Exception {  
    	mockMvc = MockMvcBuilders.standaloneSetup(controller).build();  
    }  
	
	@Test
	@Transactional
	@Rollback(true)
	public void saveUser() throws Exception {
        /*User user = new User();
        user.setAccount("xuke111111111");
        user.setUsername("徐柯111111111111111");
        user.setPassword("13456");
       /controller.save(user);*/
		
		
        MvcResult mvcResult = mockMvc.perform(post("/user/save")
        		.param("username", "徐柯")
        		.param("account", "xuke")
        		.accept(MediaType.parseMediaType("application/json;charset=UTF-8")))  
        		.andExpect(status().isOk())  
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(header().string("Content-Type", "application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.username").value("xuke"))
                .andDo(print()).andReturn();
        String users = mvcResult.getResponse().getContentAsString();
        System.out.println(users);
        
	}
	
	
	@Test
	public void getUser() throws Exception {
		 MvcResult result = mockMvc.perform(get("/user/get/{id}",1)).andReturn();
		 int statusCode = result.getResponse().getStatus();  
		 Assert.assertEquals(statusCode, 200);  
	     String body = result.getResponse().getContentAsString();  
	     System.out.println("body:"+body);  
	}
	
	
	@Test
	public void testLogin() throws Exception {
		 MvcResult result = mockMvc.perform(get("/login"))
				 .andDo(print()).andReturn();
		 int statusCode = result.getResponse().getStatus();  
		 Assert.assertEquals(statusCode, 200);  
	     String body = result.getResponse().getContentAsString();  
	     System.out.println("body:"+body);  
	}
}
