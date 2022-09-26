package com.accenture.lkm.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.lkm.service.MaterialService;
import com.accenture.lkm.test.dao.MaterialServiceDAOTest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaterialServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(MaterialServiceDAOTest.class);

	@Autowired
	private MaterialService materialService;

	@Test
	public void notNullMaterialServiceTest() {

		assertNotNull(materialService);

	}

	@Test
	public void notNullGetMaterialDetailsTest() {

		assertNotNull(materialService.getMaterialCategories());

	}

	@Test
	public void countGetMaterialDetailsTest() {

		assertEquals(materialService.getMaterialCategories().size(), 3);

	}

	@Test
	public void recordGetMaterialDetailsTest() {

		assertEquals(materialService.getMaterialCategories().get(0).getCategoryName(), "Thread");

	}

}
