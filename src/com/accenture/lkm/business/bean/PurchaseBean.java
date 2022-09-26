package com.accenture.lkm.business.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/*
 *Declare fields to set or get purchaseid, transactionId, vendor name,material category id,material type id,
 *brand name, unit id,quantity,purchase amount, balance, purchase date,material category name,
  material type name,material unit name and status.
  Validate the fields using spring validation annotations.
 *Generate toString method. Add default and parameterized constructors.
 */
public class PurchaseBean { 
	@Override
	public String toString() {
		return "PurchaseBean [purchaseId=" + purchaseId + ", brandname=" + brandname + ", materialCategoryId="
				+ materialCategoryId + ", materialTypeId=" + materialTypeId + ", purchaseAmount=" + purchaseAmount
				+ ", purchaseDate=" + purchaseDate + ", quantity=" + quantity + ", status=" + status + ", transactionId="
				+ transactionId + ", unitId=" + unitId + ", vendorName=" + vendorName + "]";
	}

	int purchaseId ;
	@NotNull
	String brandname  ;
	@NotEmpty
	String materialCategoryId  ;
	
	String materialCategoryName;
	@NotEmpty
	String materialTypeId;
	
	String materialTypeName;
	@NotNull
	Double purchaseAmount ;
    
	
	Date purchaseDate  ;
	

	int quantity  ;
	
	String status  ;
    
	String transactionId  ;
	@NotEmpty
	String unitId ;
	String unitName;
	String vendorName  ;
	
	public String getMaterialCategoryName() {
		return materialCategoryName;
	}

	public void setMaterialCategoryName(String materialCategoryName) {
		this.materialCategoryName = materialCategoryName;
	}

	public String getMaterialTypeName() {
		return materialTypeName;
	}

	public void setMaterialTypeName(String materialTypeName) {
		this.materialTypeName = materialTypeName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getMaterialTypeId() {
		return materialTypeId;
	}

	public void setMaterialTypeId(String materialTypeId) {
		this.materialTypeId = materialTypeId;
	}
	
	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getMaterialCategoryId() {
		return materialCategoryId;
	}

	public void setMaterialCategoryId(String materialCategoryId) {
		this.materialCategoryId = materialCategoryId;
	}

	public Double getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(Double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	
	public PurchaseBean() {
		super();
	}

	public PurchaseBean(int purchaseId, String brandname, String materialCategoryId, String materialTypeId,
			Double purchaseAmount, Date purchaseDate, int quantity, String status, String transactionId, String unitId,
			String vendorName) {
		super();
		this.purchaseId = purchaseId;
		this.brandname = brandname;
		this.materialCategoryId = materialCategoryId;
		this.materialTypeId = materialTypeId;
		this.purchaseAmount = purchaseAmount;
		this.purchaseDate = purchaseDate;
		this.quantity = quantity;
		this.status = status;
		this.transactionId = transactionId;
		this.unitId = unitId;
		this.vendorName = vendorName;
	}
	
	
	
}
//
