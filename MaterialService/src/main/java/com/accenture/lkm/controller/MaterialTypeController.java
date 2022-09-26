package com.accenture.lkm.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.service.MaterialService;

@RestController
public class MaterialTypeController {

	private static final Logger logger = LoggerFactory.getLogger(MaterialTypeController.class);
	
	
	/*
	 * Autowire the MaterialService object
	 * 
	 * */
	
	// Your Code Here
	@Autowired
	private MaterialService materialService;
	
	@RequestMapping(value= "/material/controller/getMaterialTypes", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MaterialTypeBean>> getMaterialTypes() {
				
		// Your Code Here
		List<MaterialTypeBean> listType=materialService.getMaterialTypes();
		return new ResponseEntity<List<MaterialTypeBean>>(listType,HttpStatus.OK);
	}
	
	
	@RequestMapping(value= "/material/controller/getMaterialTypesById/{categoryId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MaterialTypeBean>> getMaterialTypes(@PathVariable String categoryId) {
				
		// Your Code Here
		List<MaterialTypeBean> listType=materialService.getMaterialTypes(categoryId);
		return new ResponseEntity<List<MaterialTypeBean>>(listType,HttpStatus.OK);
	}
	@RequestMapping(value="/material/controller/getMaterialTypesByTypeId/{typeid}" , method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MaterialTypeBean> getMaterialTypebyId(@PathVariable String typeid){
		MaterialTypeBean mtbean = materialService.getMaterialbyId(typeid) ;
		return new ResponseEntity<MaterialTypeBean>(mtbean , HttpStatus.OK) ;
	}
	
}
