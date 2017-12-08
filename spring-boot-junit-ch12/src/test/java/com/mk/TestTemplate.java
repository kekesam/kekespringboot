package com.mk;  
  
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;  
  
/**
 * 
 * mock测试
 * TestTemplate<br/>
 * 创建人:xuke<br/>
 * 时间：2017年12月4日-下午10:46:55 <br/>
 * @version 1.0.0<br/>
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@WebAppConfiguration  
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:applicationContext.mvc.xml"})  
@Rollback(value=false)
@Transactional  
public class TestTemplate {  
    @Autowired  
    private WebApplicationContext wac;  
      
    private MockMvc mockMvc;  
    private MockHttpSession session;  
  
    @Before  
    public void setup() {  
        this.mockMvc = webAppContextSetup(this.wac).build();  
        this.session = new MockHttpSession();  
    }  
  
    @Test  
    public void getUserMsg() throws Exception {  
        this.mockMvc  
        .perform((get("/user/userMsg/003"))  
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))  
        .andExpect(status().isOk())  
        .andExpect(content().contentType("application/json;charset=UTF-8"))  
        .andDo(print()); 
    }  
  
    @Test  
    @Rollback(false)  
    public void putUserMsg() throws Exception {  
        this.mockMvc  
        .perform((put("/user/userMsg/003"))  
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)  
                .param("userName","新名字03号")  
                .session((MockHttpSession)getLoginSession())  
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8"))  
                )  
        .andExpect(status().isOk())  
        .andExpect(content().contentType("application/json;charset=UTF-8"))  
        .andDo(print()); // print  
    }  
  
    @Test  
    public void delUser() throws Exception {  
        this.mockMvc  
        .perform((delete("/user/userMsg/004"))  
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8"))  
                )  
        .andExpect(status().isOk())  
        .andExpect(content().contentType("application/json;charset=UTF-8"))  
        .andDo(print()); //print  
    }  
      
    @Test  
    @Rollback(false)  
    public void postUser() throws Exception{  
        this.mockMvc  
        .perform((post("/user/userMsg"))  
                .param("userName", "最新的用户")  
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8"))  
                )  
        .andExpect(status().isOk())  
        .andExpect(content().contentType("application/json;charset=UTF-8"))  
        .andDo(print()); //print  
    }  
      
    private HttpSession getLoginSession() throws Exception{  
        MvcResult result = this.mockMvc  
        .perform((get("/user/userMsg/loginUser/loginUser")))  
        .andExpect(status().isOk())  
        .andReturn();  
        return result.getRequest().getSession();  
    }  
}  