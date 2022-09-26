package com.accenture.lkm.test.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.controller.MaterialController;
import com.accenture.lkm.service.MaterialService;


@RunWith(SpringRunner.class)
@WebMvcTest(MaterialController.class)
public class MaterialServiceControllerTest {

	//private static final Logger logger = LoggerFactory.getLogger(MaterialServiceControllerTest.class);
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MaterialService materialService;

	
	
	
	@Test
	public void indexMaterialControllerTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk())
				.andExpect(content().string("Welcome to Spring Boot Material Service API!-dot is beautiful"));
	}
	
	
	@Test
	public void materialListMaterialControllerTest() throws Exception {

		
		  MaterialCategoryBean bean = new MaterialCategoryBean("C001","Thread"); 
		  List<MaterialCategoryBean> beansList = new ArrayList<>(); 
		  beansList.add(bean);
		  
		  when(materialService.getMaterialCategories()).thenReturn(beansList);
		  
		  mockMvc.perform(MockMvcRequestBuilders.get("/material/controller/getMaterialCategories"))
		  .andExpect(status().isOk())
		  .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)) 
		  
		  // check size of json object 
		  .andExpect(jsonPath("$", hasSize(1)))
		  
		  //check if the json node exsits
		  .andExpect(jsonPath("$[0].categoryId").exists())
		  .andExpect(jsonPath("$[0].categoryName").exists())
		  
		  //check the type of json node
		  .andExpect(jsonPath("$[0].categoryId").isString())
		  .andExpect(jsonPath("$[0].categoryName").isString())
		  
		  //check the return value 
		  .andExpect(jsonPath("$[0].categoryId").value("C001"))
		  .andExpect(jsonPath("$[0].categoryName").value("Thread"));
		 		

	}
	
	
	
}
