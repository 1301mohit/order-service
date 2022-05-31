package com.java.orderservice.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.java.orderservice.api.common.Payment;
import com.java.orderservice.api.common.TransactionRequest;
import com.java.orderservice.api.common.TransactionResponse;
import com.java.orderservice.api.dao.OrderRepository;
import com.java.orderservice.api.entity.Order;

@Service
//@RefreshScope
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
//	@Lazy
	private RestTemplate template;
	
//	@Value("${microservice.payment-service.endpoints}")
//	private String ENDPOINT_URI;
	
	public TransactionResponse saveOrder(TransactionRequest request) {
		String response = "";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		//payment api call
		Payment paymentResponse = template.postForObject("http://PAYMENT-SERVICE/payment/doPayement", payment, Payment.class);
		response = paymentResponse.getPaymentStatus().equals("success")?"Payment processing successful and order placed":"there is a failure in payment api, order added to cart";
		repository.save(order);
		return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
	}
	
}
