package com.accenture.lkm.web.client;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.exceptions.MicroServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.javafx.scene.text.HitInfo;

@Service
public class VendorServiceConsumer {

	private static Logger LOGGER = Logger.getLogger(VendorServiceConsumer.class);

	@Value("${VendorServiceConsumer.serviceURL}")
	private String serviceURL;

	@Value("${VendorServiceConsumer.apiURL}")
	private String apiURL;

	private List<VendorBean> vendorBeanList;

	private Map<String, VendorBean> vendorMap;

	private RestTemplate restTemplate;

	public List<VendorBean> getVendorBeanList() throws MicroServiceException {
		vendorBeanList  = hitGetVendorDetails() ;
		return vendorBeanList;
	}

	public Map<String, VendorBean> getVendorMap() {
		return vendorMap;
	}

	public VendorServiceConsumer() {
		restTemplate = new RestTemplate();
	}

	/**
	 * This method is hitting vendor microservice to get the list of vendors
	 * @return 
	 * 
	 * @return
	 * @throws MicroServiceException
	 */
	private static  List<VendorBean> hitGetVendorDetails() throws MicroServiceException {  
       RestTemplate rt  = new RestTemplate() ;
       List<LinkedHashMap<String, Object>> VendorMap = rt.getForObject("http://localhost:8087/vendor/controller/getVendors", List.class);
       ObjectMapper mapper =  new ObjectMapper();
	   List<VendorBean> list  = new ArrayList<VendorBean>();
		if (VendorMap != null) {
			for (LinkedHashMap<String, Object> map : VendorMap) {
				//Map object should be converted to Employee type 
				VendorBean vendorbean=mapper.convertValue(map, VendorBean.class);
				list.add(vendorbean);
			}
			System.out.println(list);
			return list ;
		} else {
			System.out.println("No user exist----------");
		}
		return list;
	}
	
}
