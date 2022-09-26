package com.accenture.lkm.business.bean;

import java.util.Date;

public class Data {
	public String vendor;
	public Date fromDate;
	public Date toDate;
	@Override
	public String toString() {
		return "Data [vendor=" + vendor + ", fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
}
