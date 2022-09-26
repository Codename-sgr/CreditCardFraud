package com.accenture.lkm.service;

import java.util.List;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.business.bean.UnitBean;

public interface MaterialService {
	MaterialCategoryBean getMaterialCategoryById(String categoryId);
	List<MaterialCategoryBean> getMaterialCategories();
	List<MaterialTypeBean> getMaterialTypes();
	List<MaterialTypeBean> getMaterialTypes(String categoryId);
	List<UnitBean> getUnits();
	List<UnitBean> getUnits(String categoryId);
	MaterialTypeBean getMaterialbyId(String typeid);
	UnitBean getUnitsbyId(String unitId);
}
