package com.alacriti.paymentGateway.payment.gateway.api.merchant.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment_info")
public class PaymentEntity {

	@Id
	private UUID id = UUID.randomUUID();

	@Column(name = "merchant_id", nullable = false)
	private String merchantId;

	@Column(name = "amount", nullable = false)
	private double amount;

	@Column(name = "currency", nullable = false)
	private String currency;

	@Column(name = "order_id", nullable = false)
	private String orderId;
	
	@Column(name = "status",nullable = false)
	private String status;
	
	@Column(name = "transaction_id",nullable =false)
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

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

}
