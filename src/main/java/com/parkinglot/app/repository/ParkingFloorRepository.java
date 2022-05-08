package com.parkinglot.app.repository;

import com.parkinglot.app.model.ParkingFloor;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingFloorRepository  extends JpaRepository<ParkingFloor, Integer> {

}