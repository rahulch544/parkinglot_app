package com.parkinglot.app.service.adminservice;

import java.util.HashMap;
import java.util.Map;

import com.parkinglot.app.model.Parkinglot;


public interface AdminService {
	
	
	public static Map<Integer,Parkinglot> parkinglot_map	= new HashMap<Integer,Parkinglot>(); ;

	public  Parkinglot createParkingLot (Map<String, Object> data);
	
	public String getParkingLotinfo(Integer parkinglot_id);

}


