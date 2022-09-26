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
@Table(name="material_type")
public class MaterialTypeEntity {
	@Id
	@Column(name="type_id")
	private String typeId;
	@Column(name="type_name")
	private String typeName;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="category_id", unique=true)
	private MaterialCategoryEntity categoryId;
	

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public MaterialCategoryEntity getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(MaterialCategoryEntity categoryId) {
		this.categoryId = categoryId;
	}
	
	
	
	
	
	

}
