package com.acme.ecommerce.controller;

import com.acme.ecommerce.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class IndexRedirectControllerTest {
	
	 final String BASE_URL = "http://localhost:8080/";
	 
	 @InjectMocks
	 private IndexRedirectController indexRedirectController;
	 
	 private MockMvc mockMvc;

	 static {
		 System.setProperty("properties.home", "/");
	 }
	 
	 @Before
	 public void setup() {
		 MockitoAnnotations.initMocks(this);
		 mockMvc = MockMvcBuilders.standaloneSetup(indexRedirectController).build();
	 }

	 @Test
	 public void redirectHome() throws Exception {
	  mockMvc.perform(MockMvcRequestBuilders.get("/"))
	   .andExpect(status().is3xxRedirection())
	   .andExpect(redirectedUrl("/product/"));
	 }
	 
	 @Test
	 public void redirectIndex() throws Exception {
	  mockMvc.perform(MockMvcRequestBuilders.get("/index.html"))
	   .andExpect(status().is3xxRedirection())
	   .andExpect(redirectedUrl("/product/"));
	 }

}
