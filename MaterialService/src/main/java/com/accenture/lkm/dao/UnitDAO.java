package com.accenture.lkm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.lkm.entity.MaterialCategoryEntity;
import com.accenture.lkm.entity.UnitEntity;


public interface UnitDAO extends JpaRepository<UnitEntity, String>{
	List<UnitEntity> findByCategoryId(MaterialCategoryEntity categoryId);
}
