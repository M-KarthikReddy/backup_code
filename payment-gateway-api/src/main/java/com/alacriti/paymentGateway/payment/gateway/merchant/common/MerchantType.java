package com.alacriti.paymentGateway.payment.gateway.merchant.common;

public enum MerchantType {
	ONLINE("online"),
	;
	
	 public String type;
	MerchantType(String type ){
		this.type = type;
	}

}
