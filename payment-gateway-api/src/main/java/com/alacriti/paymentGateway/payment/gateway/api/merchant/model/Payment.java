package com.alacriti.paymentGateway.payment.gateway.api.merchant.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Payment {

	@JsonProperty("merchantId")
	private String merchantID;

	@JsonProperty("amount")
	private double amount;
	@JsonProperty("currency")
	private String currencyType;
	@JsonProperty("orderId")
	private String orderId;
	@JsonProperty("status")
	private String status;
	@JsonProperty("transactionId")
	private String transactionId;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getMerchantID() {
		return merchantID;
	}

	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Payment(String merchantID, double amount, String currencyType, String orderId) {
		this.merchantID = merchantID;
		this.amount = amount;
		this.currencyType = currencyType;
		this.orderId = orderId;
	}

}