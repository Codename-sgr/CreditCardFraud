package com.accenture.lkm.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lkm.dao.MaterialCategoryDAO;
import com.accenture.lkm.entity.MaterialCategoryEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaterialServiceDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(MaterialServiceDAOTest.class);

	@Autowired
	private MaterialCategoryDAO materialCategoryDAO;

	@Test
	public void testNotNull() {

		assertNotNull(materialCategoryDAO);

	}

	@Test
	public void testMaterialCategoryValue() {

		MaterialCategoryEntity entity = materialCategoryDAO.findOne("C001");

		assertEquals(entity.getCategoryName(), "Thread");

	}
}
