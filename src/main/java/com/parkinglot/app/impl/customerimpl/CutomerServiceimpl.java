package com.parkinglot.app.impl.customerimpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkinglot.app.service.customerservice.CustomerService;
import com.parkinglot.app.service.parkinglotservice.ParkinglotService;

@Service
public class CutomerServiceimpl implements CustomerService{
	
	@Autowired
	private ParkinglotService parkinglotService;

	@Override
	public String parkTwoWheeler(Map<String, Object> data) {
		
		Integer parking_lot_id = Integer.valueOf((String) data.get("parking_lot_id"));
	    Integer parking_fees = parkinglotService.getParkingFee(parking_lot_id,2);  
		
		return parkinglotService.parkTwoWheeler(data) + "\n" +"Parking Fees "+parking_fees;
		
	}

}
