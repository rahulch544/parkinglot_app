package com.parkinglot.app.repository;

import java.util.List;

import com.parkinglot.app.model.Person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository  extends JpaRepository<Person, Integer> {
    
    public boolean existsByEmail(String email);

    public List<Person> findByEmail(String email);
    
    @Query("select max(p.id) from Person p")
    public Integer findByMaxId();

}