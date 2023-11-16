package com.alacriti.paymentGateway.payment.gateway.api.merchant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alacriti.paymentGateway.payment.gateway.api.merchant.entity.MerchantEntity;
import com.alacriti.paymentGateway.payment.gateway.api.merchant.model.Merchant;
import com.alacriti.paymentGateway.payment.gateway.api.merchant.repository.MerchantRepository;

@Service
public class MerchantService {
	
	@Autowired
	private MerchantRepository merchantRepository;

	/**
	 * this method will register the pojo merchant details into entity
	 */
	public void registerMerchant(Merchant merchant) {
		MerchantEntity entity = new MerchantEntity();
		 
		
		entity.setMerchantId(merchant.getMerchantId());
		entity.setMerchantName(merchant.getMerchantName());
		entity.setMerchantEmail(merchant.getMerchantEmail());
		entity.setMerchantBusinessType(merchant.getMerchantBusinesstype());
		entity.setMerchantAddress(merchant.getMerchantAddress());
		entity.setMerchantPhone(merchant.getMerchantPhone());
		
		merchantRepository.save(entity);
		
	}
	
}
