package com.accenture.lkm.web.controller;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.accenture.lkm.business.bean.Data;
import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.exceptions.MicroServiceException;
import com.accenture.lkm.services.PurchaseServiceImpl;
import com.accenture.lkm.services.ReportService;
import com.accenture.lkm.web.client.MaterialCategoryConsumer;
import com.accenture.lkm.web.client.MaterialTypeConsumer;
import com.accenture.lkm.web.client.UnitServiceConsumer;
import com.fasterxml.jackson.databind.ObjectMapper;



/**
* <br/>
* CLASS DESCRIPTION: <br/>
* A controller class for receiving and handling all material purchase related
* transactions from the User Interface. <br/>
*
*/
@RestController
@CrossOrigin(origins = "*")
public class ReportsController {

	@Autowired
	PurchaseServiceImpl purchaseServiceimpl;
	// Auto wire MaterialCategoryConsumer here
	@Autowired
	MaterialCategoryConsumer materialCategoryConsumer;
	// Auto wire UnitServiceConsumer here
	@Autowired
	UnitServiceConsumer unitServiceConsumer;
	// Auto wire MaterialTypeConsumer here
	@Autowired
	MaterialTypeConsumer materialTypeConsumer;
	
	@Autowired
	ReportService reportService;
	/**
	* METHOD DESCRIPTION: <br/>
	* This method is used to get report details for Generate report in REACT client.
	* Upon successful it returns list of purchase entries
	* @return ResponseEntity<List<PurchaseBean>>
	* @throws Exception
	*/

	@RequestMapping(value="/rest/getPurchaseReports", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PurchaseBean>> getReport(@RequestBody Data data ) throws MicroServiceException {
		// Your Code Here
		List<PurchaseBean> list = reportService.getReport(data.getFromDate(),data.getToDate(),data.getVendor());
		
		if(list!= null) {
			for(PurchaseBean purchaseBean:list) {
			
				String unitId=purchaseBean.getUnitId();
				String typeId=purchaseBean.getMaterialTypeId();
				MaterialTypeBean type=materialTypeConsumer.hitGetMaterialTypeById(typeId);
				UnitBean unit=unitServiceConsumer.hitGetMaterialTypeById(unitId);
				
				purchaseBean.setMaterialTypeName(type.getTypeName());
				purchaseBean.setUnitName(unit.getUnitName());
				
				MaterialCategoryBean category=materialCategoryConsumer.hitGetMaterialCategoryById(purchaseBean.getMaterialCategoryId());
				purchaseBean.setMaterialCategoryName(category.getCategoryName());
			}
			return new ResponseEntity<List<PurchaseBean>>(list, HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<List<PurchaseBean>>(HttpStatus.NOT_FOUND);
		}
		
	}

}