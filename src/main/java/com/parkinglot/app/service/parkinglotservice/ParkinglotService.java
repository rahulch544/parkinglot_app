package com.parkinglot.app.service.parkinglotservice;

import java.util.Map;

public interface ParkinglotService {
	
	public Integer getParkingFee(Integer parking_lot_id,Integer vehicle_type);
	
	public String parkTwoWheeler(Map<String, Object> data);

}
