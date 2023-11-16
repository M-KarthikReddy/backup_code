package com.alacriti.paymentGateway.payment.gateway.api.merchant.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.alacriti.paymentGateway.payment.gateway.api.merchant.entity.PaymentEntity;
import com.alacriti.paymentGateway.payment.gateway.api.merchant.model.Payment;
import com.alacriti.paymentGateway.payment.gateway.api.merchant.model.PaymentResponse;
import com.alacriti.paymentGateway.payment.gateway.api.merchant.repository.PaymentRepository;
import com.alacriti.paymentGateway.payment.gateway.merchant.common.Currency;
import com.alacriti.paymentGateway.payment.gateway.merchant.common.Status;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	
	

	public PaymentResponse requestPayment(Payment requestDetails) {
		
		PaymentEntity entity = new PaymentEntity();
		
		String msg = "SUCESSFUL...";

		try {
			validateCurrency(requestDetails);
			saveData(requestDetails, Status.SUCESS.status,entity);
			
		}

		catch (Exception e) {

			saveData(requestDetails, Status.FAIL.status,entity);
			msg = e.getMessage();
		}
		
		PaymentResponse response =  sendPaymentStatus(entity);
		
		response.setMessage(msg);
		
		return response;

	}

	private void saveData(Payment payment, String status,PaymentEntity entity) {
		

		entity.setMerchantId(payment.getMerchantID());
		entity.setAmount(payment.getAmount());
		entity.setCurrency(payment.getCurrencyType());
		entity.setOrderId(payment.getOrderId());
		entity.setTransactionId("" + Math.random());

		entity.setStatus(status);
		paymentRepository.save(entity);

	}

	public void validateCurrency(Payment payment) throws Exception {

		if (!payment.getCurrencyType().equals(Currency.INDIA.currency)) {
			throw new Exception("invalid currency");
		}

	}
	
	public PaymentResponse sendPaymentStatus(PaymentEntity entity) {
		
		PaymentResponse response = new PaymentResponse();
		
		response.setMerchantID(entity.getMerchantId());
		response.setOrderId(entity.getOrderId());
		response.setTransactionId(entity.getTransactionId());
		response.setStatus(entity.getStatus());
		
		return response;
		
		
	}
	
	public List<PaymentResponse> getPaymentDetailsByTransId(String transactionID) {
		PaymentResponse response = new PaymentResponse();
		
		List<PaymentResponse> listOfResponse = new ArrayList<>();
		String sql = "select * from payment_info where transaction_id ='" + transactionID + "'";
		listOfResponse = jdbcTemplate.query(sql, new RowMapper() {

			@Override
			public PaymentResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
				PaymentResponse response = new PaymentResponse();
				String id=rs.getString("transaction_id");
				String status=rs.getString("status");
				String mId = rs.getString("merchant_id");
				String Oid = rs.getString("order_id");
				
				
				response.setTransactionId(id);
				response.setStatus(status);
				response.setMerchantID(mId);
				response.setOrderId(Oid);
				return response;
				
			}
		});
		return listOfResponse;
		
	}
}
