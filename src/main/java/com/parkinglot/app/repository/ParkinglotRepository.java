package com.parkinglot.app.repository;

import com.parkinglot.app.model.Parkinglot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkinglotRepository  extends JpaRepository<Parkinglot, Integer> {

}