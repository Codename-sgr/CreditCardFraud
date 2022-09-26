package com.accenture.lkm.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;


import com.accenture.lkm.entity.PurchaseEntity;

@RepositoryDefinition(idClass=String.class,domainClass = PurchaseEntity.class)
@Transactional
public interface ReportDAO{
	@Query("select k from PurchaseEntity k where k.purchaseDate Between ?1 and ?2 and k.vendorName=?3")
	List<PurchaseEntity> getReport(Date fromDate,Date toDate,String vendor);
}
