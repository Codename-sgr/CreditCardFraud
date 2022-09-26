package com.accenture.lkm.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.services.PurchaseService;

public class PurchaseServiceTest {
	@Autowired
	private PurchaseService purchaseService;


	
	@Test
	public void testAddPurchaseDetails(){
		//implementation goes here
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse("2020-05-17");
		
			PurchaseBean purchaseBean = new PurchaseBean(1, "Kanchi", "C001", "T001", 400.0, date, 4, "Pending", "P_ONL_05172020_THR_1", "U001", "Only Vimal");
			PurchaseBean purchaseBean1;
			purchaseBean1 = purchaseService.addPurchaseDetails(purchaseBean);
			Assert.assertTrue("Error in AddPurchaseDetails in PurchaseService", purchaseBean1!=null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
