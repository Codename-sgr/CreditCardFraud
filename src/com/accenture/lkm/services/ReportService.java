package com.accenture.lkm.services;

import java.util.Date;
import java.util.List;

import com.accenture.lkm.business.bean.PurchaseBean;


public interface ReportService {
	List<PurchaseBean> getReport(Date fromDate,Date toDate,String vendor);
}
