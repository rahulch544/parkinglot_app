package com.parkinglot.app.model;

public class parkingslot {
	private Integer slot_no;
	private Vehicle vehicle;
	private Integer parkinglot_id;
	private Integer floor;
	private Boolean slot_filled;
	
	public parkingslot(Integer slot_no, Vehicle vehicle, Integer parkinglot_id, Integer floor) {
		super();
		this.slot_no = slot_no;
		this.vehicle = vehicle;
		this.parkinglot_id = parkinglot_id;
		this.floor = floor;
		this.setSlot_filled(true);
	}
	
	public Integer getSlot_no() {
		return this.slot_no;
	}
	public void setSlot_no(Integer slot_no) {
		this.slot_no = slot_no;
	}
	public Vehicle getVehicle() {
		return this.vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Integer getParkinglot_id() {
		return this.parkinglot_id;
	}
	public void setParkinglot_id(Integer parkinglot_id) {
		this.parkinglot_id = parkinglot_id;
	}
	public Integer getFloor() {
		return this.floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public Boolean getSlot_filled() {
		return this.slot_filled;
	}

	public void setSlot_filled(Boolean slot_filled) {
		this.slot_filled = slot_filled;
	}
	
	@Override
	public String toString() {
		return "parkingslot [\nslot_no = " + slot_no + " \n, vehicle = " + vehicle + " \n, parkinglot_id = "
				+ parkinglot_id + " \n, floor = " + floor + " \n, slot_filled = " + slot_filled + "\n]";
	}
	

}
