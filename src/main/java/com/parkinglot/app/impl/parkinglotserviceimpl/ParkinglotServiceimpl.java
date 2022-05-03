package com.parkinglot.app.impl.parkinglotserviceimpl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.parkinglot.app.model.ParkingFloor;
import com.parkinglot.app.model.Parkinglot;
import com.parkinglot.app.model.Vehicle;
import com.parkinglot.app.service.adminservice.AdminService;
import com.parkinglot.app.service.parkinglotservice.ParkinglotService;


@Service
public class ParkinglotServiceimpl implements ParkinglotService {
	
	Map<Integer,Parkinglot> parkinglot_map = AdminService.parkinglot_map;

	@Override
	public Integer getParkingFee(Integer parking_lot_id, Integer vehicle_type) {
		
		Integer parking_fees =-1;
		if(AdminService.parkinglot_map.containsKey(parking_lot_id)) {
			
			switch (vehicle_type){
				case 2:{
					parking_fees =	AdminService.parkinglot_map.get(parking_lot_id).getTwo_wheeler_fees();
					break;
				}
				case 4:{
					parking_fees =	AdminService.parkinglot_map.get(parking_lot_id).getFour_wheeler_fees();
				}
				default:{
					parking_fees =0;
				}
			}
		}
		
		return parking_fees;
	}
	
	
	public String parkTwoWheeler(Map<String, Object> data) {
		try {
			
			Integer parking_lot_id = Integer.valueOf((String) data.get("parking_lot_id"));
		    Integer floor_no = Integer.valueOf((String) data.get("floor_no"));
			Parkinglot parkinglot = parkinglot_map.get(parking_lot_id);
			ParkingFloor parkingFloor = parkinglot.parking_floors.get(floor_no-1);
			
			Vehicle two_wheeler =  new Vehicle((String) data.get("regd_no"),2,"Black");
			
			int slot_id = parkingFloor.fillTwo_wheeler_slot(two_wheeler,parking_lot_id,floor_no);
			
			if(slot_id==-1) {
				return "No Space available or invalid floor";
			}else {
				return "Slot booking for two wheeler successfull with slot number :"+slot_id;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "No Space available or invalid floor";
		}
		
	}




}
