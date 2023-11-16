package com.alacriti.paymentGateway.payment.gateway.merchant.common;

public enum Currency {
	INDIA("IND"),
	USA("USD"),
	ARGENTINA("PESO"),
	BRAZIL("REAL"),
	CANADA("CAD"),
	CZEHREPUBLIC("KORUNA"),
	JAPAN("JPY"),
	AUSTRALIA("AUD"),
	EUROPE("EURO"),
	SWIZERLAND("CHF");
	
	public String currency;
	 Currency(String currency) {
		this.currency = currency;
	}

}
