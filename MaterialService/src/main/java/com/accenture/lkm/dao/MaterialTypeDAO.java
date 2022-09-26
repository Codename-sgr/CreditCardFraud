package com.accenture.lkm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.lkm.entity.MaterialCategoryEntity;
import com.accenture.lkm.entity.MaterialTypeEntity;


public interface MaterialTypeDAO extends JpaRepository<MaterialTypeEntity, String>{
	List<MaterialTypeEntity> findByCategoryId(MaterialCategoryEntity categoryId);
}
