package com.parkinglot.app.controller.admincontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkinglot.app.model.Parkinglot;
import com.parkinglot.app.service.adminservice.AdminService;

@RestController
@RequestMapping("/adminController")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	

	
	@PostMapping("/createParkingLot")
	public String createParkingLot(@RequestBody(required = true) Map<String, Object> data) {
		
		Parkinglot parkinglot = adminService.createParkingLot(data);
		
		AdminService.parkinglot_map.put(parkinglot.getParking_lot_id(), parkinglot);
//		parkinglotRepository.save(parkinglot);
		
		return (parkinglot.getParking_lot_id()).toString();
	}
	
	@GetMapping("/getParkingLotinfo/{id}")
	public String getParkingLotinfo(@PathVariable("id") Integer parkinglot_id) {
			
		return adminService.getParkingLotinfo(parkinglot_id);
	}

}
