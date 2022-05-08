package com.parkinglot.app.controller.personController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parkinglot.app.model.Person;
import com.parkinglot.app.service.personService.PersonService;

@RestController
public class PersonController {
	
	
    @Autowired 
    private PersonService personService;
    
    
    
    @RequestMapping(value="createperson",method=RequestMethod.POST)
    public String createPerson(@RequestBody Person person) {
    	return personService.createPerson(person);
    }
    
    @RequestMapping(value="readpersons",method=RequestMethod.GET)
    public List<Person> readPersons() {
    	return personService.readPersons();
    }
}