package com.accenture.lkm.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.dao.PurchaseDAO;
import com.accenture.lkm.entity.PurchaseEntity;
import com.accenture.lkm.web.client.MaterialCategoryConsumer;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	private static Logger LOGGER = Logger.getLogger(PurchaseServiceImpl.class);

	// Auto wire PurchaseDAO here
	@Autowired
	PurchaseDAO purchaseDAO; 
	/**
	 * METHOD DESCRIPTION: <br/>
	 * This method is used to insert purchase details data into the purchase
	 * table. Also, this method will add a single row into the payment table
	 * with paid amount as zero to keep the track of the balance amount for a
	 * specific purchase.
	 * 
	 * @param purchaseBean
	 * @return purchaseBean
	 * @throws Exception
	 */
	@Override
	public PurchaseBean addPurchaseDetails(PurchaseBean purchaseBean) throws Exception {
		return insertPurchaseDetails(purchaseBean);
	}

	/**
	 * METHOD DESCRIPTION: <br/>
	 * This method will be called by addPurchaseDetails method to insert the
	 * data into the Purchase table.
	 * 
	 * @param purchaseBean
	 * @return purchaseBean
	 * @throws Exception
	 */
	private PurchaseBean insertPurchaseDetails(PurchaseBean purchaseBean) throws Exception {
		String transactionId = transactionIdGenerator(purchaseBean.getVendorName(), purchaseBean.getMaterialCategoryId(), purchaseBean.getPurchaseDate());
		purchaseBean.setTransactionId(transactionId);	
		System.out.println(transactionId);
		purchaseBean.setStatus("PENDING");
		PurchaseEntity purchaseEntity=convertPurchaseBeanToEntity(purchaseBean);
		LOGGER.info("Service class entity "+purchaseEntity);
		PurchaseEntity purchaseEntity2= purchaseDAO.savePurchaseDetail(purchaseEntity);
		
		LOGGER.info("Service class returned entity" +purchaseEntity2);
		return convertPurchaseEntityToBean(purchaseEntity2);
	}

	/**
	 * METHOD DESCRIPTION: <br/>
	 * This method is used to generate the transaction id as per logic- P_first
	 * 3 characters of vendor name_purchase date in mmddyyyy format_first 3
	 * characters of material category purchased_primary key of purchase table
	 * 
	 * @param vendorName
	 * @param materialCategoryName
	 * @param purchaseDate
	 * @return String
	 */
	private String transactionIdGenerator(String vendorName, String materialCategoryId, Date purchaseDate) {
		SimpleDateFormat f=new SimpleDateFormat("MMddyyyy");
		String d=f.format(purchaseDate);
		int count=purchaseDAO.countRecord()+1;
		System.out.println("count"+count);
		MaterialCategoryConsumer materialCategoryConsumer=new MaterialCategoryConsumer();
		MaterialCategoryBean materialCategoryBean=new MaterialCategoryBean();
		try {
		materialCategoryBean= materialCategoryConsumer.hitGetMaterialCategoryById(materialCategoryId);
	    }catch (Exception e) {
			// TODO: handle exception
		}
	    String materialCategoryName=materialCategoryBean.getCategoryName();
	    String transactionId = "P_" + vendorName.toUpperCase().substring(0, 3) + "_" + d + "_" + materialCategoryName.substring(0, 3).toUpperCase() + "_" + count;
		System.out.println(transactionId);
		return transactionId;
	}
	
//	public List<PurchaseBean> getPurchaseList(String vendorName, Date startDate, Date endDate) {
//		List<PurchaseEntity> purchaseEntity2 = purchaseDAO.getPurchaseList(vendorName, startDate, endDate);
//
//		List<PurchaseBean> purchaseBean = new ArrayList<>();
//		for (PurchaseEntity entity : purchaseEntity2) {
//			purchaseBean.add(convertPurchaseEntityToBean(entity));
//		}
//		return (purchaseBean);
//	}

	
	private PurchaseBean convertPurchaseEntityToBean(PurchaseEntity entity) {
		PurchaseBean bean = new PurchaseBean();
		BeanUtils.copyProperties(entity, bean);
		return bean;
	}
	
	private PurchaseEntity convertPurchaseBeanToEntity(PurchaseBean bean) {
		PurchaseEntity entity = new PurchaseEntity();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}


}
