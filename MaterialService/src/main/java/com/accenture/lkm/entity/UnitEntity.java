package com.accenture.lkm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "unit")
public class UnitEntity {
	@Id
	@Column(name = "unit_id")
	private String unitId;

	@Column(name = "unit_name")
	private String unitName;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="category_id", unique=true)
	private MaterialCategoryEntity categoryId;

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public MaterialCategoryEntity getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(MaterialCategoryEntity categoryId) {
		this.categoryId = categoryId;
	}

}
