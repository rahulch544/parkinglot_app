package com.parkinglot.app.repository;

import com.parkinglot.app.model.parkingslot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingslotRepository  extends JpaRepository<parkingslot, Integer> {

}