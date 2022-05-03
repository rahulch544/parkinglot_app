package com.parkinglot.app.controller.customercontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkinglot.app.service.customerservice.CustomerService;


@RestController
@RequestMapping("/customerController")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@PostMapping("/parkTwoWheeler")
	public  String parkTwoWheeler (@RequestBody(required = true) Map<String, Object> data) {
		
		return customerService.parkTwoWheeler(data);
	}
	
//	@PutMapping("/EmptyparkTwoWheeler")
//	public  String parkTwoWheeler (@RequestBody(required = true) Map<String, Object> data) {
//		
//		return customerService.parkTwoWheeler(data);
//	}
}
