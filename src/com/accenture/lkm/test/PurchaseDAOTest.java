package com.accenture.lkm.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.dao.PurchaseDAOImpl;
import com.accenture.lkm.entity.PurchaseEntity;




public class PurchaseDAOTest {
	@Autowired
	private PurchaseDAOImpl purchaseDAOImpl; 
	
	
	@Test
	public void testSavePurchaseDetail(){
		//implementation goes here
		try {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2020-05-17");
		PurchaseBean purchaseBean = new PurchaseBean(1, "Kanchi", "C001", "T001", 400.0, date, 4, "Pending", "P_ONL_05172020_THR_1", "U001", "Only Vimal");
		PurchaseEntity purchaseEntity = new PurchaseEntity();
		BeanUtils.copyProperties(purchaseBean, purchaseEntity);
		PurchaseEntity entity = purchaseDAOImpl.savePurchaseDetail(purchaseEntity);
		Assert.assertTrue("Error in SavePurchaseDetails in PurchaseDAOImpl", entity!=null);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
