package com.accenture.lkm.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.PurchaseBean;

import com.accenture.lkm.entity.PurchaseEntity;

import com.accenture.lkm.dao.ReportDAO;


@Service
public class ReportServiceImpl implements ReportService{

	private static final Logger logger = LoggerFactory.getLogger(ReportServiceImpl.class);
	
	/*
	 * Autowire reportDAO object
	 * 
	 * */
	@Autowired
	ReportDAO reportDAO;
	
	// Your Code Here

	
	/*
	 * Method - getVendorDetails()
	 * Use the reportDAO to get all the vendors
	 * Check if vendors is not empty then 
	 * 		Declare VendorBean object with null value
	 * 		Loop through all the vendors 
	 * 			Create a new bean object 
	 * 			Copy each property value of entity object to bean object
	 * 			Add the bean object to the vendorBeans list
	 * */

	@Override
	public List<PurchaseBean> getReport(Date fromDate,Date toDate,String vendor) {
		List<PurchaseBean> beanList = null;
		List<PurchaseEntity> entityList = reportDAO.getReport(fromDate, toDate,vendor);
		// Your Code Here
		if(!entityList.isEmpty()) {
			beanList = new ArrayList<PurchaseBean>();
			for(PurchaseEntity entity: entityList) {
				PurchaseBean bean = new PurchaseBean(); 
				BeanUtils.copyProperties(entity, bean);
				beanList.add(bean);
			}
		}
		return beanList;
	} 
}
