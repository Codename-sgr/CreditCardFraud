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

import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.controller.UnitController;
import com.accenture.lkm.service.MaterialService;
//import com.accenture.lkm.service.MaterialTypeService;
//import com.accenture.lkm.service.UnitService;

@RunWith(SpringRunner.class)
@WebMvcTest(UnitController.class)
public class UnitControllerTest {

	//private static final Logger logger = LoggerFactory.getLogger(UnitControllerTest.class);
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MaterialService materialService;

//	@MockBean
//	private MaterialTypeService materialTypeService;
	
//	@MockBean
//	private UnitService unitService;
	
	
	
	/*@Test
	public void indexVendorControllerTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(status().isOk())
				.andExpect(content().string("Welcome to Spring Boot Material Service API!-dot is beautiful"));
	}*/
	
	
	@Test
	public void unitListUnitControllerTest() throws Exception {

		
		  UnitBean bean = new UnitBean("U001","Metres","C001"); 
		  List<UnitBean> beansList = new ArrayList<>(); 
		  beansList.add(bean);
		  String categoryId="C001";
		  when(materialService.getUnits(categoryId)).thenReturn(beansList);
		  
		  mockMvc.perform(MockMvcRequestBuilders.get("/material/controller/getUnitsById/C001"))
		  .andExpect(status().isOk())
		  .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)) 
		  
		  // check size of json object 
		  .andExpect(jsonPath("$", hasSize(1)))
		  
		  //check if the json node exsits
		  .andExpect(jsonPath("$[0].categoryId").exists())
		  .andExpect(jsonPath("$[0].unitName").exists())
		  .andExpect(jsonPath("$[0].unitId").exists())
		  
		  //check the type of json node
		  .andExpect(jsonPath("$[0].categoryId").isString())
		  .andExpect(jsonPath("$[0].unitName").isString())
		  .andExpect(jsonPath("$[0].unitId").isString())
		  
		  //check the return value 
		  .andExpect(jsonPath("$[0].categoryId").value("C001"))
		  .andExpect(jsonPath("$[0].unitName").value("Metres"))
		  .andExpect(jsonPath("$[0].unitId").value("U001"));
		 		

	}
	
	
	
}
