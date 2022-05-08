package com.parkinglot.app.model;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;


@Entity
@Table(name="PARKING_FLOOR")
public class ParkingFloor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer floor_no;
	
	private Integer two_wheeler_capacity=0; 
	private Integer four_wheeler_capacity=0;
	private Integer[] entries;
	private Integer two_wheeler_slots_filled = 0;
	private Integer four_wheeler_slots_filled = 0;
//	private Boolean[] two_wheeler_slots;

	@OneToMany(mappedBy ="parkingFloor",cascade = CascadeType.ALL)	
	@OrderColumn
	private parkingslot[] two_wheeler_slots;


	
	private Boolean[] four_wheeler_slots;
	
	
	@ManyToOne
    @JoinTable(name = "parkinglot_floor",
    			joinColumns = {@JoinColumn(name = "floor_id",referencedColumnName ="floor_no")},
				inverseJoinColumns = {@JoinColumn(name = "parkinglot_id", referencedColumnName ="parking_lot_id")}
    		  )
	private Parkinglot parkinglot;
	
	
	public ParkingFloor() {
		super();
	}
	
	public ParkingFloor(Integer two_wheeler_capacity, Integer four_wheeler_capacity, Integer floor_no,
			Integer[] entries) {
		super();
		this.two_wheeler_capacity = two_wheeler_capacity;
		this.four_wheeler_capacity = four_wheeler_capacity;
		// this.floor_no = floor_no;
		this.entries = entries;
		this.setTwo_wheeler_slots(new parkingslot[two_wheeler_capacity]);
		Arrays.fill(this.two_wheeler_slots,null);
		this.setFour_wheeler_slots(new Boolean[four_wheeler_capacity]);
		Arrays.fill(this.four_wheeler_slots,false);

		
	}

	

	public ParkingFloor(Integer two_wheeler_capacity, Integer four_wheeler_capacity, Integer floor_no) {
		super();
		this.two_wheeler_capacity = two_wheeler_capacity;
		this.four_wheeler_capacity = four_wheeler_capacity;
		// this.floor_no = floor_no;
		this.entries = new Integer[1];
		this.setTwo_wheeler_slots(new parkingslot[two_wheeler_capacity]);
		Arrays.fill(this.two_wheeler_slots,null);
		this.setFour_wheeler_slots(new Boolean[four_wheeler_capacity]);
		Arrays.fill(this.four_wheeler_slots,false);
	}



	public Integer getTwo_wheeler_capacity() {
		return two_wheeler_capacity;
	}



	public void setTwo_wheeler_capacity(Integer two_wheeler_capacity) {
		this.two_wheeler_capacity = two_wheeler_capacity;
	}



	public Integer getFour_wheeler_capacity() {
		return four_wheeler_capacity;
	}



	public void setFour_wheeler_capacity(Integer four_wheeler_capacity) {
		this.four_wheeler_capacity = four_wheeler_capacity;
	}



	public Integer getFloors() {
		return floor_no;
	}



	public void setFloors(Integer floors) {
		this.floor_no = floors;
	}



	public Integer[] getEntries() {
		return entries;
	}



	public void setEntries(Integer[] entries) {
		this.entries = entries;
	}

	public Integer getTwo_wheeler_slots_filled() {
		return two_wheeler_slots_filled;
	}

	public void setTwo_wheeler_slots_filled(Integer two_wheeler_slots_filled) {
		this.two_wheeler_slots_filled = two_wheeler_slots_filled;
	}

	public Integer getFour_wheeler_slots_filled() {
		return four_wheeler_slots_filled;
	}

	public void setFour_wheeler_slots_filled(Integer four_wheeler_slots_filled) {
		this.four_wheeler_slots_filled = four_wheeler_slots_filled;
	}



	public parkingslot[] getTwo_wheeler_slots() {
		return this.two_wheeler_slots;
	}

	public void setTwo_wheeler_slots(parkingslot[] two_wheeler_slots) {
		this.two_wheeler_slots = two_wheeler_slots;
	}

	public Boolean[] getFour_wheeler_slots() {
		return four_wheeler_slots;
	}

	public void setFour_wheeler_slots(Boolean[] four_wheeler_slots) {
		this.four_wheeler_slots = four_wheeler_slots;
	}
	
	public Integer fillTwo_wheeler_slot(Vehicle two_wheeler,Integer parkinglot_id,Integer floor_no) {
		parkingslot[] two_wheeler_slots=this.two_wheeler_slots;
		Integer slot_no =-1; 
		for(int i=0;i<two_wheeler_slots.length;i++) {
			parkingslot two_wheeler_slot = two_wheeler_slots[i];
			if(two_wheeler_slot == null) {
				two_wheeler_slots[i] = new parkingslot(i,two_wheeler,parkinglot_id,floor_no);
				slot_no = i;
				break;
			}
			System.out.println("Slot"+two_wheeler_slot);
		}
		return slot_no;
	}
	
	@Override
	public String toString() {
		return "ParkingFloor [\ntwo_wheeler_capacity = " + two_wheeler_capacity + " \n, four_wheeler_capacity = "
				+ four_wheeler_capacity + " \n, floor_no = " + floor_no + " \n, entries = " + Arrays.toString(entries)
				+ " \n, two_wheeler_slots_filled = " + two_wheeler_slots_filled + " \n, four_wheeler_slots_filled = "
				+ four_wheeler_slots_filled + " \n, two_wheeler_slots = " + Arrays.toString(two_wheeler_slots)
				+ " \n, four_wheeler_slots = " + Arrays.toString(four_wheeler_slots) + " \n, parkinglot = " + parkinglot
				+ "\n]";
	}

	public Parkinglot getParkinglot() {
		return parkinglot;
	}

	public void setParkinglot(Parkinglot parkinglot) {
		this.parkinglot = parkinglot;
	}

	
}
