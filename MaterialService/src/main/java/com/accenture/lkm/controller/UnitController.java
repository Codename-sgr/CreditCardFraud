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


import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.service.MaterialService;

@RestController
public class UnitController {

	private static final Logger logger = LoggerFactory.getLogger(UnitController.class);
	
	
	/*
	 * Autowire the MaterialService object
	 * 
	 * */
	
	// Your Code Here
	@Autowired
	private MaterialService materialService;
	
	@RequestMapping(value= "/material/controller/getUnits", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UnitBean>> getUnits() {
				
		// Your Code Here
		List<UnitBean> listUnit=materialService.getUnits();
		return new ResponseEntity<List<UnitBean>>(listUnit,HttpStatus.OK);
	}

	
	@RequestMapping(value= "/material/controller/getUnitsById/{categoryId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UnitBean>> getUnits(@PathVariable String categoryId) {
				
		// Your Code Here
		List<UnitBean> listUnit=materialService.getUnits(categoryId);
		return new ResponseEntity<List<UnitBean>>(listUnit,HttpStatus.OK);
	}
	
	@RequestMapping(value= "/material/controller/getUnitsByunitId/{unitId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UnitBean> getUnitsByid(@PathVariable String unitId) {

	// Your Code Here
		UnitBean unitBean=materialService.getUnitsbyId(unitId);
		System.out.println(unitBean);
	return new ResponseEntity<UnitBean>(unitBean,HttpStatus.OK);
	}
	
}
