package com.accenture.lkm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.service.VendorService;
import com.accenture.lkm.service.VendorServiceImpl;

@RestController
@CrossOrigin(origins="*")
public class VendorController {

	private static final Logger logger = LoggerFactory.getLogger(VendorController.class);
	
	/*
	 * Autowire the VendorService object
	 * 
	 * */
	@Autowired
	private VendorService vendorService;
	// Your Code Here
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "Welcome to Spring Boot Vendor Service API!";
	}

	
	/* 
	 * Method - getVendorDetails()
	 * Fetch all the vendor details using VendorService and store it inside a List
	 * Return a ResponseEntity object passing the list of vendor details
	 * 
	 */
	
	@RequestMapping(value="/vendor/controller/getVendors", method=RequestMethod.GET)
	public ResponseEntity<List<VendorBean>> getVendorDetails() throws Exception {
		// Your Code Here
		List<VendorBean> listVendor = vendorService.getVendorDetails();
		return new ResponseEntity<List<VendorBean>>(listVendor,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/vendor/controller/getVendorsById/{id}", method=RequestMethod.GET)
	public ResponseEntity< VendorBean> getVendorDetailsById(@PathVariable("id") String vendorId ) throws Exception {
		// Your Code Here
		VendorBean Vendor = vendorService.getVendorDetailsbyId(vendorId);
		if(Vendor!=null)
			{
				return new ResponseEntity<VendorBean>(Vendor,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<VendorBean>(HttpStatus.NOT_FOUND);
			}		
	}
//	
//	@RequestMapping(value="emp/controller/getDetailsById/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<EmployeeBean> getEmployeeDetailByEmployeeId(@PathVariable("id") int myId) throws Exception{
//		EmployeeBean employee = employeeService.getEmployeeDetailByEmployeeId(myId);
//		
//		if(employee!=null)
//		{
//			return new ResponseEntity<EmployeeBean>(employee,HttpStatus.OK);
//		}
//		else
//		{
//			return new ResponseEntity<EmployeeBean>(HttpStatus.NOT_FOUND);
//		}
//	}
}
