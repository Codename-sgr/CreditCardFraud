package com.accenture.lkm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 *Declare fields to set or get purchaseid, transactionId, vendor name,material category id,material type id,
 *brand name, unit id,quantity,purchase amount, purchase date and status.
 *Generate toString method. Add default and parameterized constructors.
 */
@Entity
@Table(name="purchase")
public class PurchaseEntity {

	@Override
	public String toString() {
		return "PurchaseEntity [purchaseId=" + purchaseId + ", brandname=" + brandname + ", materialCategoryId="
				+ materialCategoryId + ", materialTypeId=" + materialTypeId + ", purchaseAmount=" + purchaseAmount
				+ ", purchaseDate=" + purchaseDate + ", quantity=" + quantity + ", status=" + status + ", transactonId="
				+ transactionId + ", unitId=" + unitId + ", vendorName=" + vendorName + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="purchase_id")  
	int purchaseId ;
	
	String brandname  ;
	
	
	@Column(name = "material_category_id")
	String materialCategoryId;
	
	@Column(name =  "material_type_id")
	String materialTypeId;
	
	
	@Column(name = "purchase_amount")
	Double purchaseAmount ;
	
	@Column(name = "purchase_date")
	@Temporal(TemporalType.DATE)
	Date purchaseDate  ;
	
	int quantity  ;
	
	String status  ;
	
	@Column(name = "transaction_id")
	String transactionId  ;
	
	@Column(name = "unit_id")
	String unitId ;
	
	@Column(name = "vendor_name")
	String vendorName  ;
	
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

	
	
}
