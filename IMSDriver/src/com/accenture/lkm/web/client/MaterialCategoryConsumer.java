package com.accenture.lkm.web.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.exceptions.MicroServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MaterialCategoryConsumer {

	private static Logger LOGGER = Logger.getLogger(MaterialCategoryConsumer.class);

	@Value("${MaterialServiceConsumer.serviceURL}")
	private String serviceURL;
	@Value("${MaterialCategoryConsumer.apiURL}")
	private String apiURL;
	@Value("${MaterialCategoryConsumer.apiURLForById}")
	private String apiURLForById;
	private RestTemplate restTemplate;
	private List<MaterialCategoryBean> materialCategoryBeanList;
	private Map<String, String> categoryMap;

	public Map<String, String> getCategoryMap() throws MicroServiceException {
		return categoryMap;
	}

	public List<MaterialCategoryBean> getMaterialCategoryBeanList() throws MicroServiceException {
		
		return materialCategoryBeanList;
	}
	
	public MaterialCategoryConsumer() {
		restTemplate = new RestTemplate();
	}

	/**
	 * This method hits material microservice to get the list of Material
	 * category.
	 * @return 
	 * 
	 * @return
	 * @throws MicroServiceException
	 */
	public Map<String, String> hitGetMaterialCategories() throws MicroServiceException {
		   List<LinkedHashMap<String, Object>> MaterialCategoryMap = restTemplate.getForObject("http://localhost:8088/material/controller/getMaterialCategories", List.class);
	       
		   
		   ObjectMapper mapper =  new ObjectMapper();
//	       List<MaterialCategoryBean> list  = new ArrayList<MaterialCategoryBean>();
	       
		   Map<String, String> categorymap = new HashMap<String, String>() ;
			
		   if (MaterialCategoryMap != null) {
				for (LinkedHashMap<String, Object> map : MaterialCategoryMap) {
					//Map object should be converted to Employee type 
					MaterialCategoryBean materialCategoryBean=mapper.convertValue(map, MaterialCategoryBean.class);
					
					categorymap.put(materialCategoryBean.getCategoryId(), materialCategoryBean.getCategoryName()) ;
						
				}
				return categorymap  ;
			} else {
				System.out.println("No user exist----------");
			}
			return null;
			
	}

	/**
	 * This method hits material microservice to get the details of Material
	 * category for given category id.
	 * 
	 * @param categoryId
	 * @return MaterialCategoryBean
	 * @throws MicroServiceException
	 */
	public MaterialCategoryBean hitGetMaterialCategoryById(String categoryId) throws MicroServiceException {
	       MaterialCategoryBean materialCategoryBean = restTemplate.getForObject("http://localhost:8088/material/controller/getMaterialCategoryById/"+categoryId, MaterialCategoryBean.class);
	     System.out.println(materialCategoryBean);
	     return materialCategoryBean  ;	   		
	}	
}
