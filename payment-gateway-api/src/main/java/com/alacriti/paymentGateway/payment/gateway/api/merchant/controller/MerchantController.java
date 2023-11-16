package com.alacriti.paymentGateway.payment.gateway.api.merchant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alacriti.paymentGateway.payment.gateway.api.merchant.entity.PaymentEntity;
import com.alacriti.paymentGateway.payment.gateway.api.merchant.model.Merchant;
import com.alacriti.paymentGateway.payment.gateway.api.merchant.model.Payment;
import com.alacriti.paymentGateway.payment.gateway.api.merchant.model.PaymentResponse;
import com.alacriti.paymentGateway.payment.gateway.api.merchant.service.MerchantService;
import com.alacriti.paymentGateway.payment.gateway.api.merchant.service.PaymentService;

@RestController
public class MerchantController {
	@Autowired
	MerchantService merchantService;

	@Autowired
	PaymentService paymentService;

	@PostMapping("/register_merchant")
	public void setMerchantData(@RequestBody Merchant merchant) {
		merchantService.registerMerchant(merchant);
	}

	@PostMapping("/payment")
	public PaymentResponse requestPayment(@RequestBody Payment payment) {
		PaymentResponse paymentResponse = paymentService.requestPayment(payment);
		return paymentResponse;
	}
	
	@GetMapping("/payment_status/{transactionId}")
	public List<PaymentResponse> paymentStatus(@PathVariable String transactionId) {
		
	
		List<PaymentResponse> paymentResponse = paymentService.getPaymentDetailsByTransId(transactionId);
		return paymentResponse;
		
		
	}

}
