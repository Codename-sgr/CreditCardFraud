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

import com.accenture.lkm.dao.UnitDAO;
import com.accenture.lkm.entity.MaterialCategoryEntity;
import com.accenture.lkm.entity.MaterialTypeEntity;
import com.accenture.lkm.entity.UnitEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(UnitDAOTest.class);
    
	@Autowired
	private UnitDAO unitDAO;
	
	@Test
	public void testNotNullUnitDAOTest() {
		Assert.assertTrue("Error test case failed", unitDAO!=null);
		
	}
	
	@Test
	public void findByIdUnitDAOTest() {
		MaterialCategoryEntity m=new MaterialCategoryEntity();
		m.setCategoryId("C001");
		List<UnitEntity> unitEntity=unitDAO.findByCategoryId(m);
		Assert.assertTrue("Error test case failed", unitEntity!=null);
		
		
	}
	

}
