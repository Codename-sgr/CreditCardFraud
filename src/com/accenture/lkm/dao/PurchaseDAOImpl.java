package com.accenture.lkm.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.entity.PurchaseEntity;
//import com.accenture.lkm.utility.JPAUtility;

/**
 * <br/>
 * CLASS DESCRIPTION: <br/>
 * Implementation class for PurchaseDAO to perform the CRUD operation on
 * Purchase table <br/>
 *
 */
@Repository
@Transactional(value = "txManager")
public class PurchaseDAOImpl implements PurchaseDAO {
	private static Logger LOGGER = Logger.getLogger(PurchaseDAOImpl.class);

	// Auto wire EntityManagerFactory here
	@PersistenceContext
	EntityManager entityManager ;
	/*
	 * This method inserts the Purchase Data into the Purchase table.
	 * 
	 * @param purchaseEntity
	 * 
	 * @return PurchaseEntity
	 */
	@Override
	public PurchaseEntity savePurchaseDetail(PurchaseEntity purchaseEntity) throws Exception {
		LOGGER.info("DAO class entity to be added" + purchaseEntity);
		try {
			entityManager.persist(purchaseEntity);
			
		} catch (Exception exception) {
			exception.printStackTrace() ;
			throw exception;
		}
//		PurchaseEntity pe = entityManager.find(PurchaseEntity.class, purchaseEntity.getPurchaseId()) ;
//		LOGGER.info("DAO Class returned purchase entity" +pe);
		return purchaseEntity ;
		
	}
	@Override
	public int countRecord() {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("Select MAX(e.purchaseId) FROM PurchaseEntity e");
		//return query.getResultList().size();
		return (int)query.getSingleResult();
	}
	
//	public List<PurchaseEntity> getPurchaseList(String vendorName, Date startDate,Date endDate){
//		Query query=entityManager.createQuery("Select p from PurchaseEntity p where p.vendorName=?1 and p.purchaseDate between ?2 and ?3");
//		query.setParameter(1,vendorName);
//		query.setParameter(2, startDate);
//		query.setParameter(3, endDate);
//		List<PurchaseEntity> purchaseEntityList= (List<PurchaseEntity>)query.getResultList();
//		return purchaseEntityList;
//		}

}
