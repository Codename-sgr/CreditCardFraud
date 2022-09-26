package com.accenture.lkm.test.service;

import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.service.MaterialServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaterialTypeServiceTest {
	
	@Autowired
	MaterialServiceImpl materialTypeServiceImpl;
	
	@Test
	public void notNullMaterialTypeServiceTest() {
		// Your Code Here
		Assert.assertTrue(materialTypeServiceImpl!=null);
	}
	
	@Test
	public void notNullGetMaterialTypeTest() {
		Collection<MaterialTypeBean> materialTypeList=materialTypeServiceImpl.getMaterialTypes("C001");
		Assert.assertTrue("Error test failed - found null", materialTypeList!=null);
	}
	
	@Test
	public void countMaterialTypeTest() {
		// Your Code Here
		Collection<MaterialTypeBean> materialTypeList=materialTypeServiceImpl.getMaterialTypes("C001");
		Assert.assertTrue("Error test failed - incorrect size list", materialTypeList.size()==1);
	}
	@Test
	public void recordGetMaterialTypeTest() {
		List<MaterialTypeBean> materialTypeList=materialTypeServiceImpl.getMaterialTypes("C001");
		String record=materialTypeList.get(0).getTypeName();
		Assert.assertTrue("Error test failed", record.equals("Silk"));
	}

}