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
import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.exceptions.MicroServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UnitServiceConsumer {

	private static Logger LOGGER = Logger.getLogger(UnitServiceConsumer.class);

	@Value("${MaterialServiceConsumer.serviceURL}")
	private String serviceURL;

	@Value("${UnitServiceConsumer.apiURL}")
	private String apiURL;

	@Value("${UnitServiceConsumer.apiURLByCategoryId}")
	private String apiURLByCategoryId;

	private List<UnitBean> unitBeanList;

	private Map<String, String> unitMap;

	private RestTemplate restTemplate;

	public List<UnitBean> getUnitBeanList() throws MicroServiceException {
		return unitBeanList;
	}

	public Map<String, String> getUnitMap() throws MicroServiceException {
		return unitMap;
	}

	public UnitServiceConsumer() {
		restTemplate = new RestTemplate();
	}

	/**
	 * This method hits material microservice to get the list of unit.
	 * 
	 * @return
	 * @throws MicroServiceException
	 */
	private void hitGetUnitDetails() throws MicroServiceException {

	}

	/**
	 * This method hits material microservice to get the list of unit available
	 * for a given category id.
	 * 
	 * @param categoryId
	 * @return List<UnitBean>
	 * @throws MicroServiceException
	 */
	public Map<String, String> hitGetUnitsByCategoryId(String categoryId) throws MicroServiceException {
            
		    List<LinkedHashMap<String, Object>> UnitServiceMap = restTemplate.getForObject("http://localhost:8088/material/controller/getUnitsById/"+categoryId, List.class);
	   
	        ObjectMapper mapper =  new ObjectMapper();
	       
//			List<UnitBean> list  = new ArrayList<UnitBean>();
			
			Map<String, String> unitMap  = new HashMap<String, String>() ;
			
			
			if (UnitServiceMap != null) {
				for (LinkedHashMap<String, Object> mapvalue : UnitServiceMap) {
					//Map object should be converted to Employee type 
					UnitBean unitbean=mapper.convertValue(mapvalue, UnitBean.class);
//					list.add(unitbean);
					unitMap.put(unitbean.getUnitId(), unitbean.getUnitName()) ;
				}
//				System.out.println(list);
				return unitMap ;
			} else {
				System.out.println("No user exist----------");
			}
			return null;

	}
	public UnitBean hitGetMaterialTypeById(String unitId) throws MicroServiceException {
		UnitBean unitBean = restTemplate.getForObject("http://localhost:8088/material/controller/getUnitsByunitId/"+unitId, UnitBean.class);
		System.out.println(unitBean);
		return unitBean ;
	}
}
