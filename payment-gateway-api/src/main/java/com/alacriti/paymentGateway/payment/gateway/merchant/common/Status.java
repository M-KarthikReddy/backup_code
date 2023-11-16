package com.alacriti.paymentGateway.payment.gateway.merchant.common;

public enum Status {
		SUCESS("sucess"),
		FAIL("fail");
	
	public String status;
	
	Status(String status){
		this.status = status;
	}
}
