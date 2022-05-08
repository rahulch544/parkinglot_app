package com.parkinglot.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="PARKINGLOT")
public class Parkinglot {
	
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer parking_lot_id;
    
    @Column(name="ADDRESS", length=200, nullable=false,unique=true)
	public String  address;
    
    @Column(name="NO_OF_FLOORS", length=200, nullable=false)
	public Integer no_of_floors;
    
    
    @OneToMany(mappedBy ="parkinglot",cascade = CascadeType.ALL)
	public List<ParkingFloor> parking_floors;
	
	private Integer two_wheeler_fees = 0;
	
	private Integer four_wheeler_fees = 0;
	
	
	
	public Parkinglot(Integer on_of_floors, List<ParkingFloor> parking_floors, String address,Integer two_wheeler_fees,Integer four_wheeler_fees) {
		super();
		this.no_of_floors = on_of_floors;
		this.parking_floors = parking_floors;
		this.address = address;
//		this.parking_lot_id = getParking_lot_id_seq();
		this.two_wheeler_fees = two_wheeler_fees;
		this.four_wheeler_fees = four_wheeler_fees;
		
	}
	


//	public static Integer getParking_lot_id_seq() {
//		parking_lot_id_seq+=1;
//		return parking_lot_id_seq;
//	}


	public Integer getNo_of_floors() {
		return no_of_floors;
	}


	public void setNo_of_floors(Integer no_of_floors) {
		this.no_of_floors = no_of_floors;
	}


	public List<ParkingFloor> getParking_floors() {
		return parking_floors;
	}


	public void setParking_floors(List<ParkingFloor> parking_floors) {
		this.parking_floors = parking_floors;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Integer getParking_lot_id() {
		return parking_lot_id;
	}


	public void setParking_lot_id(Integer parking_lot_id) {
		this.parking_lot_id = parking_lot_id;
	}


	public Integer getTwo_wheeler_fees() {
		return two_wheeler_fees;
	}



	public void setTwo_wheeler_fees(Integer two_wheeler_fees) {
		this.two_wheeler_fees = two_wheeler_fees;
	}



	public Integer getFour_wheeler_fees() {
		return four_wheeler_fees;
	}



	public void setFour_wheeler_fees(Integer four_wheeler_fees) {
		this.four_wheeler_fees = four_wheeler_fees;
	}



	@Override
	public String toString() {
		return "Parkinglot [\nparking_lot_id = " + parking_lot_id + " \n, address = " + address + " \n, no_of_floors = "
				+ no_of_floors + " \n, parking_floors = " + parking_floors + " \n, two_wheeler_fees = "
				+ two_wheeler_fees + " \n, four_wheeler_fees = " + four_wheeler_fees + "\n]";
	}


	
}
