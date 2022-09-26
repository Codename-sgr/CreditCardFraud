package com.accenture.lkm.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.dao.MaterialCategoryDAO;
import com.accenture.lkm.dao.MaterialTypeDAO;
import com.accenture.lkm.dao.UnitDAO;
import com.accenture.lkm.entity.MaterialCategoryEntity;
import com.accenture.lkm.entity.MaterialTypeEntity;
import com.accenture.lkm.entity.UnitEntity;

@Service
public class MaterialServiceImpl implements MaterialService {

	private static final Logger logger = LoggerFactory.getLogger(MaterialServiceImpl.class);

	
	/*
	 * Autowire MaterialCategoryDAO object
	 * 
	 * */
	@Autowired
	private MaterialCategoryDAO dao;
	
	@Autowired
	private MaterialTypeDAO daoType;
	
	@Autowired
	private UnitDAO daoUnit;
	
	
	// Your Code Here
	

	/*
	 * Method - getMaterialCategoryById()
	 * Use MaterialCategoryDAO object findById method to fetch the entity by --> categoryId
	 * Check if the entity is present
	 * 		initialized the materialCategoryBean object
	 * 		copy the properties value from entity to materialCategoryBean object
	 * */
	
	@Override
	public MaterialCategoryBean getMaterialCategoryById(String categoryId) {
		
		MaterialCategoryBean materialCategoryBean = null;
		
		// Your Code Here
		MaterialCategoryEntity x= dao.findOne(categoryId);
		
	    if(x!=null){
	    	materialCategoryBean = new MaterialCategoryBean();		
			BeanUtils.copyProperties(x, materialCategoryBean);
	    }
		
		
		return materialCategoryBean;
	}

	
	/*
	 * Method - getMaterialCategories()
	 * Use the MaterialCategoryDAO to get all the MaterialCategoryEntity objects
	 * Check if list is not empty then 
	 * 		Declare a MaterialCategoryBean object with null value
	 * 		Loop through all the material categories
	 * 			Initialize a new MaterialCategoryBean object 
	 * 			Copy each property value of entity object to bean object
	 * 			Add the bean object to the materialCategoryBeans list
	 * */

	
	@Override
	public List<MaterialCategoryBean> getMaterialCategories() {
		
		List<MaterialCategoryBean> materialCategoryBeans = new ArrayList<MaterialCategoryBean>();
		
		// Your Code Here
		Iterable<MaterialCategoryEntity> listEn= dao.findAll();
		if(listEn!=null) {
		listEn.forEach(x->{
			MaterialCategoryBean category = new MaterialCategoryBean();
			BeanUtils.copyProperties(x, category);
			materialCategoryBeans.add(category);
		});
		}
		
		
		return materialCategoryBeans;
	}

	
	@Override
	public List<MaterialTypeBean> getMaterialTypes() {
		// TODO Auto-generated method stub
		List<MaterialTypeBean> materialTypeBeans = new ArrayList<MaterialTypeBean>();
		
		// Your Code Here
		Iterable<MaterialTypeEntity> listEn= daoType.findAll();
		if(listEn!=null) {
		listEn.forEach(x->{
			MaterialTypeBean type = new MaterialTypeBean();
			BeanUtils.copyProperties(x, type);
			type.setCategoryId(x.getCategoryId().getCategoryId());
			materialTypeBeans.add(type);
		});
		}
		
		
		return materialTypeBeans;

	}

	
	@Override
	public List<MaterialTypeBean> getMaterialTypes(String categoryId) {
		// TODO Auto-generated method stub
		List<MaterialTypeBean> materialTypeBeans = new ArrayList<MaterialTypeBean>();
		
		// Your Code Here
		MaterialCategoryEntity m=new MaterialCategoryEntity();
		m.setCategoryId(categoryId);
		Iterable<MaterialTypeEntity> listEn= daoType.findByCategoryId(m);
		if(listEn!=null) {
		listEn.forEach(x->{
			MaterialTypeBean type = new MaterialTypeBean();
			BeanUtils.copyProperties(x, type);
			type.setCategoryId(categoryId);
			materialTypeBeans.add(type);
		});
		}
		
		
		return materialTypeBeans;
	}

	
	@Override
	public List<UnitBean> getUnits() {
		// TODO Auto-generated method stub
		List<UnitBean> unitBeans = new ArrayList<UnitBean>();
		
		// Your Code Here
		Iterable<UnitEntity> listEn= daoUnit.findAll();
		if(listEn!=null) {
		listEn.forEach(x->{
			UnitBean unit = new UnitBean();
			BeanUtils.copyProperties(x, unit);
			unit.setCategoryId(x.getCategoryId().getCategoryId());
			unitBeans.add(unit);
		});
		}
		
		
		return unitBeans;

	}

	@Override
	public List<UnitBean> getUnits(String categoryId) {
		// TODO Auto-generated method stub
		List<UnitBean> unitBeans = new ArrayList<UnitBean>();
		
		// Your Code Here
		MaterialCategoryEntity m=new MaterialCategoryEntity();
		m.setCategoryId(categoryId);
		Iterable<UnitEntity> listEn= daoUnit.findByCategoryId(m);
		if(listEn!=null) {
		listEn.forEach(x->{
			UnitBean unit = new UnitBean();
			BeanUtils.copyProperties(x, unit);
			unit.setCategoryId(categoryId);
			unitBeans.add(unit);
		});
		}
		
		
		return unitBeans;
	}
	
	@Override
	public MaterialTypeBean getMaterialbyId(String typeid) {
	MaterialTypeEntity mtenti = daoType.findOne(typeid) ;
	MaterialTypeBean mtBean = new MaterialTypeBean() ;
	mtBean.setTypeName(mtenti.getTypeName());
	System.out.println(mtBean);
	return mtBean ;
	}




	@Override
	public UnitBean getUnitsbyId(String unitId) {
		// TODO Auto-generated method stub
		UnitEntity unitentity = daoUnit.findOne(unitId) ;
		UnitBean ubean = new UnitBean() ;
		ubean.setUnitName(unitentity.getUnitName());
		if(ubean !=null)
			return ubean;
		else
			return null ;
	}

		

}
