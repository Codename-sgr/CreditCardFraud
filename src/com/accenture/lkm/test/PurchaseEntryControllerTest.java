package com.accenture.lkm.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.exceptions.MicroServiceException;
import com.accenture.lkm.services.PurchaseService;
import com.accenture.lkm.web.client.MaterialCategoryConsumer;
import com.accenture.lkm.web.client.MaterialTypeConsumer;
import com.accenture.lkm.web.client.UnitServiceConsumer;
import com.accenture.lkm.web.client.VendorServiceConsumer;

public class PurchaseEntryControllerTest {
	
	@Autowired
	private PurchaseService purchaseService;

	@Autowired
	private VendorServiceConsumer vendorServiceConsumer;

	@Autowired
	private MaterialCategoryConsumer materialCategoryConsumer;

	@Autowired
	private UnitServiceConsumer unitServiceConsumer;

	@Autowired
	private MaterialTypeConsumer materialTypeConsumer;
	
	@Test
	public void testPurchaseEntry() {
		//implementation goes here
	}

	@Test
	public void testGenerateVendorList() {
		//implementation goes here
		try {
		List<VendorBean> vendorList= vendorServiceConsumer.getVendorBeanList();
	//	Assert.assertTrue("Error, VendorList generation Failed", vendorList!=null);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	
	@Test
	public void testGenerateUnitAndTypeList(){
		//implementation goes here
		try {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2020-05-17");
		
		PurchaseBean purchaseBean = new PurchaseBean(1, "Kanchi", "C001", "T001", 400.0, date, 4, "Pending", "P_ONL_05172020_THR_1", "U001", "Only Vimal");
		Map<String,String> listUnitBean = unitServiceConsumer.hitGetUnitsByCategoryId(purchaseBean.getMaterialCategoryId());
		Map<String,String> listmaterialTypeBean = materialTypeConsumer.hitGetTypesBasedOnCategoryId(purchaseBean.getMaterialCategoryId());
		Assert.assertTrue("Error, UnitList generation Failed", listUnitBean!=null);
		Assert.assertTrue("Error, MaterialTypeList generation Failed", listmaterialTypeBean != null);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Test
	public void testGenerateCategoryList(){
		//implementation goes here
		try {
		List<MaterialCategoryBean> materialCategoryList = materialCategoryConsumer.getMaterialCategoryBeanList();
		Assert.assertTrue("Error, MaterialTypeList Failed", materialCategoryList!=null);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testAddPurchaseDetail() {
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
