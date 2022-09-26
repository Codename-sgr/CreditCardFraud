 package com.accenture.lkm.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.MaterialCategoryBean;
import com.accenture.lkm.business.bean.MaterialTypeBean;
import com.accenture.lkm.business.bean.PurchaseBean;
import com.accenture.lkm.business.bean.UnitBean;
import com.accenture.lkm.business.bean.VendorBean;
import com.accenture.lkm.exceptions.MicroServiceException;
import com.accenture.lkm.services.PurchaseService;
import com.accenture.lkm.web.client.MaterialCategoryConsumer;
import com.accenture.lkm.web.client.MaterialTypeConsumer;
import com.accenture.lkm.web.client.UnitServiceConsumer;
import com.accenture.lkm.web.client.VendorServiceConsumer;

/**
 * <br/>
 * CLASS DESCRIPTION: <br/>
 * A controller class for receiving and handling all material purchase related
 * transactions from the User Interface. <br/>
 *
 */
@Controller
@SessionAttributes({ "purchaseBean" })
public class PurchaseEntryController {

	private static Logger LOGGER = Logger.getLogger(PurchaseEntryController.class);

	// Auto wire PurchaseService here
	@Autowired
	private PurchaseService purchaseService;
	// Auto wire VendorServiceConsumer here
	@Autowired
	private VendorServiceConsumer vendorServiceConsumer;
	// Auto wire MaterialCategoryConsumer here
	@Autowired
	private MaterialCategoryConsumer materialCategoryConsumer;
	// Auto wire UnitServiceConsumer here
	@Autowired
	private UnitServiceConsumer unitServiceConsumer;
	// Auto wire MaterialTypeConsumer here
	@Autowired
	private MaterialTypeConsumer materialTypeConsumer;
	/**
	 * METHOD DESCRIPTION: <br/>
	 * This method sets PurchaseBean into the model attribute and redirects to
	 * PurchaseEntry.jsp.
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "purchaseEntry.html", method = RequestMethod.GET)
	public ModelAndView purchaseEntry() throws Exception {
		//LOGGER.info("Purchase Entry bean entered");
		ModelAndView modelAndView  = new ModelAndView() ;
		modelAndView.setViewName("PurchaseEntry");
		PurchaseBean purchaseBean = new PurchaseBean();
		modelAndView.addObject("purchaseBean", purchaseBean);
		return modelAndView;
	}

	/**
	 * METHOD DESCRIPTION: <br/>
	 * This method returns the vendor list to be populated on the
	 * PurchasEntry.jsp. getVendorBeanList method of VendorServiceConsumer is
	 * called to get the vendor list.
	 * 
	 * @return vendorList - List of vendor values
	 * @throws MicroServiceException
	 */
	@ModelAttribute("vendorList")
	public List<String> generateVendorList() throws MicroServiceException {
		List<VendorBean> vendorBeanList = new ArrayList<VendorBean>();
		vendorBeanList = vendorServiceConsumer.getVendorBeanList();
		List<String> list = new ArrayList<String>();
		
		for(VendorBean bean: vendorBeanList)
			list.add(bean.getVendorName());
		return list;
	}

	/**
	 * METHOD DESCRIPTION: <br/>
	 * This method returns the material unit and type list to be populated in
	 * PurchaseEntry.jsp for chosen material category. hitGetUnitsByCategoryId
	 * method of UnitServiceConsumer class to be called to get the list of
	 * material unit. hitGetTypesBasedOnCategoryId method of
	 * MaterialTypeConsumer class to be called to get the list of material type.
	 * 
	 * @param purchaseBean
	 * @param HttpSession
	 * @return ModelAndView
	 * @throws MicroServiceException
	 */
	@RequestMapping(value = "getUnitAndTypeList.html", method = RequestMethod.POST)
	public ModelAndView generateUnitAndTypeList(@ModelAttribute("purchaseBean") PurchaseBean purchaseBean,
			HttpSession session) throws MicroServiceException {
		purchaseBean.setMaterialTypeId("1");
		Map<String,String> unitBeanList =unitServiceConsumer.hitGetUnitsByCategoryId(purchaseBean.getMaterialCategoryId());
		
		Map<String,String> materialTypeList = materialTypeConsumer.hitGetTypesBasedOnCategoryId(purchaseBean.getMaterialCategoryId());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("PurchaseEntry");
		modelAndView.addObject("purchaseBean", purchaseBean);
		//LOGGER.info("purchaseBean" + purchaseBean + purchaseBean.getMaterialTypeId());		
		modelAndView.addObject("unitBeanList",unitBeanList);
		//LOGGER.info("unitBeanList"+ unitBeanList);
		modelAndView.addObject("materialTypeList", materialTypeList);
		//LOGGER.info("materialTypeList"+ materialTypeList);
		return modelAndView;
	}

	/**
	 * METHOD DESCRIPTION: <br/>
	 * This method returns the material category list to be populated on the
	 * PurchasEntry.jsp. getMaterialCategoryBeanList method of
	 * MaterialCategoryConsumer is called to get the material category list.
	 * 
	 * @return List - MaterialCategoryBean
	 * @throws MicroServiceException
	 */
	@ModelAttribute("categoryList")
	public Map<String,String> generateCategoryList() throws MicroServiceException {
	
		return materialCategoryConsumer.hitGetMaterialCategories();
	}

	/**
	 * METHOD DESCRIPTION: <br/>
	 * This method is used to insert purchase details filled on
	 * PurchaseEntry.jsp in to the purchase and payment table. Upon successful
	 * insert redirects to PurchaseSuccess.jsp
	 * 
	 * @param purchaseBean
	 * @param BindingResult
	 * @param ModelMap
	 * @param HttpSession
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "addPurchaseDetail.html", method = RequestMethod.POST)
	public ModelAndView addPurchaseDetail(@ModelAttribute("purchaseBean") @Valid PurchaseBean purchaseBean,
			BindingResult result, ModelMap map, HttpSession session) throws Exception {
		  // LOGGER.info("purchase bean controller" + purchaseBean);
		ModelAndView modelAndView = new ModelAndView();
		// System.out.println(purchaseBean.getBrandname()+purchaseBean.getUnitId()+purchaseBean.getPurchaseAmount()) ;
		
		try {
			if(result.hasErrors()) {
				modelAndView.setViewName("PurchaseEntry");
				String errorMessage="Please fill the fields correctly!!";
				modelAndView.addObject("error", errorMessage);
				
			}
			else {
				PurchaseBean bean = purchaseService.addPurchaseDetails(purchaseBean);
				System.out.println(bean);
//				LOGGER.info("Controller returned bean" + bean);
				if(bean != null) {
					String unitId=bean.getUnitId();
					String typeId=bean.getMaterialTypeId();
					MaterialTypeBean type=materialTypeConsumer.hitGetMaterialTypeById(typeId);
					UnitBean unit=unitServiceConsumer.hitGetMaterialTypeById(unitId);
					
					bean.setMaterialTypeName(type.getTypeName());
					bean.setUnitName(unit.getUnitName());
					
					MaterialCategoryBean category=materialCategoryConsumer.hitGetMaterialCategoryById(bean.getMaterialCategoryId());
					bean.setMaterialCategoryName(category.getCategoryName());
					
					modelAndView.addObject("bean" ,bean) ;
				//	LOGGER.info("if statementbean "+bean);
					modelAndView.setViewName("PurchaseSuccess");
				}
				else {
					String errorMessage=" theere !!";
					modelAndView.setViewName("error");
					modelAndView.addObject("errMsg", errorMessage);
				}
			}
		}
		catch(Exception e) {
		//	LOGGER.info(e);
			modelAndView.setViewName("error");
			modelAndView.addObject("errMsg", e.getMessage());			
		}
		
		return modelAndView;
	}
	
	@ExceptionHandler(value=MicroServiceException.class)
	public ModelAndView handleException(MicroServiceException exception) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("errMsg",exception.getMessage());
		modelAndView.setViewName("error");
		return modelAndView;
	}
}