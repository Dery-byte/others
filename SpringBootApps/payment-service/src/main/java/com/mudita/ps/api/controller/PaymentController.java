package com.mudita.ps.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.mudita.ps.api.entity.Payment;
import com.mudita.ps.api.service.PaymentService;

@RestController

@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	
	@PostMapping("/doPayment")
	public Payment makePayment(@RequestBody Payment payment) {
		
		return paymentService.doPayment(payment);
		
	}
	
}
