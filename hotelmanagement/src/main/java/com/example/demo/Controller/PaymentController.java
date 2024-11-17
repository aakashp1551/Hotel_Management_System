package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.PaymentRepository;
import com.example.demo.entity.Payment;

@RestController
	@RequestMapping("/payments")
	public class PaymentController {

	    @Autowired
	    private PaymentRepository paymentRepository;

	    @GetMapping
	    public List<Payment> getAllPayments() {
	        return paymentRepository.findAll();
	    }

	    @PostMapping
	    public Payment createPayment(@RequestBody Payment payment) {
	        return paymentRepository.save(payment);
	    }

	    @GetMapping("/{id}")
	    public Payment getPaymentById(@PathVariable Long id) {
	        return paymentRepository.findById(id).orElseThrow();
	    }

	    @PutMapping("/{id}")
	    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
	        payment.setId(id);
	        return paymentRepository.save(payment);
	    }

	    @DeleteMapping("/{id}")
	    public void deletePayment(@PathVariable Long id) {
	        paymentRepository.deleteById(id);
	    }

}
