package com.accenture.lkm.test.service;

import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.service.MaterialServiceImpl;
//import com.accenture.lkm.service.UnitServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitServiceTest {
	
	@Autowired
	MaterialServiceImpl unitServiceImpl;
	
	@Test
	public void notNullUnitServiceTest() {
		// Your Code Here
		Assert.assertTrue(unitServiceImpl!=null);
	}
	
	@Test
	public void notNullGetUnitDetailsTest() {
		Collection<UnitBean> unitList=unitServiceImpl.getUnits("C001");
		Assert.assertTrue("Error test failed", unitList!=null);
	}
	
	@Test
	public void countUnitDetailsTest() {
		// Your Code Here
		Collection<UnitBean> unitList=unitServiceImpl.getUnits("C001");
		Assert.assertTrue("Error test failed", unitList.size()==2);
	}
	@Test
	public void recordGetUnitDetailsTest() {
		List<UnitBean> unitList=unitServiceImpl.getUnits("C001");
		String record=unitList.get(0).getUnitId();
		Assert.assertTrue("Error test failed", record.equals("U001"));
	}


}