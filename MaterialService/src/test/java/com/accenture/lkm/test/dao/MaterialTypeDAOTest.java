package com.accenture.lkm.test.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lkm.dao.MaterialTypeDAO;
import com.accenture.lkm.entity.MaterialCategoryEntity;
import com.accenture.lkm.entity.MaterialTypeEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaterialTypeDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MaterialTypeDAOTest.class);
    
	@Autowired
	private MaterialTypeDAO materialTypeDAO;
	
	@Test
	public void testNotNullMAterialTypeDAOTest() {
		Assert.assertTrue("Error test case failed", materialTypeDAO!=null);
	}
	
	@Test
	public void findByIdMaterialTypeDAOTest() {
		MaterialCategoryEntity m=new MaterialCategoryEntity();
		m.setCategoryId("C001");
		List<MaterialTypeEntity> materialTypeEntity=materialTypeDAO.findByCategoryId(m);
		Assert.assertTrue("Error test Failed", materialTypeEntity!=null);
		
	}

}
