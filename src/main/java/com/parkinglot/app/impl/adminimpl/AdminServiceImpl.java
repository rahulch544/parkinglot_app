package com.parkinglot.app.impl.adminimpl;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.parkinglot.app.model.ParkingFloor;
import com.parkinglot.app.model.Parkinglot;
import com.parkinglot.app.repository.ParkinglotRepository;
import com.parkinglot.app.service.adminservice.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private ParkinglotRepository parkinglotRepository; 
	
    @Transactional
	public Parkinglot createParkingLot (Map<String, Object> data) {
		
		
		 Integer on_of_floors = Integer.valueOf((String) data.get("on_of_floors"));
		 String  address = data.get("address").toString();
		 Integer two_wheeler_fees = Integer.valueOf((String) data.get("two_wheeler_fees"));
		 Integer four_wheeler_fees = Integer.valueOf((String) data.get("four_wheeler_fees"));
		 
		 @SuppressWarnings("unchecked")
		ArrayList<ArrayList<Integer>> floor_details = (ArrayList<ArrayList<Integer>>) data.get("floor_details");
		 List<ParkingFloor> parking_floors = new ArrayList<ParkingFloor>();
		 
		 for(ArrayList<Integer> floor : floor_details) {

			 	 Integer two_wheeler_capacity = floor.get(0);
				 Integer four_wheeler_capacity = floor.get(1);
				 Integer floor_no = floor.get(2); 
				 Integer no_of_entries = 1;
				 if(floor.size() ==4) {
					 no_of_entries = floor.get(3);
				 }
				 Integer[] entries = new Integer[no_of_entries];
				 
				 
				 ParkingFloor parking_floor = new ParkingFloor(two_wheeler_capacity,
						 									   four_wheeler_capacity,
						 									   floor_no,
						 									   entries
						 									   );	 
				 parking_floors.add(parking_floor);
			 
		 }
		 
		 Parkinglot parking_lot=  new Parkinglot( on_of_floors, 
				 									parking_floors, 
				 									address,
				 									two_wheeler_fees,
				 									four_wheeler_fees);

		 parkinglotRepository.save(parking_lot);
		return  parking_lot;
	}
	
	public String getParkingLotinfo(@PathVariable("id") Integer parkinglot_id) {
		
		if(AdminService.parkinglot_map.containsKey(parkinglot_id)) {
			return AdminService.parkinglot_map.get(parkinglot_id).toString();
		}else {
			return "No Parking lot found for give Id: "+parkinglot_id;
		}
		
	}
	
}
