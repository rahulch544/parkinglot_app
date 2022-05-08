package com.parkinglot.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="VEHICLE")
public class Vehicle {
	
	@Id
	private String regd_no;
	
	private Integer vehicle_type;
	private String color;
	
	@OneToOne(mappedBy = "vehicle", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
    private parkingslot parkingslot;

	public String getRegd_no() {
		return regd_no;
	}
	public Vehicle(String regd_no, Integer vehicle_type, String color) {
		super();
		this.regd_no = regd_no;
		this.vehicle_type = vehicle_type;
		this.color = color;
	}
	public void setRegd_no(String regd_no) {
		this.regd_no = regd_no;
	}
	public Integer getVehicle_type() {
		return vehicle_type;
	}
	public void setVehicle_type(Integer vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Vehicle [\nregd_no = " + regd_no + " \n, vehicle_type = " + vehicle_type + " \n, color = " + color
				+ " \n, parkingslot = " + parkingslot + "\n]";
	}
	
}
