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
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.exceptions.MicroServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MaterialTypeConsumer {

	private static Logger LOGGER = Logger.getLogger(MaterialTypeConsumer.class);

	@Value("${MaterialServiceConsumer.serviceURL}")
	private String serviceURL;

	@Value("${MaterialTypeConsumer.apiURL}")
	private String apiURL;

	@Value("${MaterialTypeConsumer.apiURLByCategoryId}")
	private String apiURLByCategoryId;

	private RestTemplate restTemplate;

	private List<MaterialTypeBean> materialTypeBeanList;

	private Map<String, String> categoryTypeMap;

	public List<MaterialTypeBean> getMaterialTypeBeanList() throws MicroServiceException {
		return materialTypeBeanList;
	}

	public Map<String, String> getCategoryTypeMap() throws MicroServiceException {
		return categoryTypeMap;
	}

	public MaterialTypeConsumer() {
		restTemplate = new RestTemplate();
	}

	/**
	 * This method hits material microservice to get the list of Material type.
	 * 
	 * @return
	 * @throws MicroServiceException
	 */
	private void hitGetMaterialType() throws MicroServiceException {

	}

	/**
	 * This method hits material microservice to get the details of Material
	 * type based on category id.
	 * 
	 * @param categoryId
	 * @return List<MaterialTypeBean>
	 * @throws MicroServiceException
	 */
	public Map<String , String> hitGetTypesBasedOnCategoryId(String categoryId) throws MicroServiceException {
		   List<LinkedHashMap<String, Object>> MaterialTypeMap = restTemplate.getForObject("http://localhost:8088/material/controller/getMaterialTypesById/"+categoryId, List.class);
	       ObjectMapper mapper =  new ObjectMapper();
//			List<MaterialTypeBean> list  = new ArrayList<MaterialTypeBean>();
			
			Map<String , String> cateMap = new HashMap<String, String>() ;
			if (MaterialTypeMap != null) {
				for (LinkedHashMap<String, Object> map : MaterialTypeMap) {
					//Map object should be converted to Employee type 
					MaterialTypeBean materialTypeBean=mapper.convertValue(map, MaterialTypeBean.class);
//					list.add(materialTypeBean);
					cateMap.put(materialTypeBean.getTypeId(), materialTypeBean.getTypeName()) ;
				}
//				System.out.println(list);
			} else {
				System.out.println("No user exist----------");
			}
			return cateMap;
	}
	public MaterialTypeBean hitGetMaterialTypeById(String TypeId) throws MicroServiceException {
		MaterialTypeBean materialTypeBean = restTemplate.getForObject("http://localhost:8088/material/controller/getMaterialTypesByTypeId/"+TypeId, MaterialTypeBean.class);
		System.out.println(materialTypeBean);
		return materialTypeBean ;
	}
}
