package com.parkinglot.app.service.personService;

import java.util.List;

import javax.transaction.Transactional;

import com.parkinglot.app.model.Person;
import com.parkinglot.app.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public String createPerson(Person person) {
        try{
            if(!personRepository.existsByEmail(person.getEmail())){

                person.setId(null==personRepository.findByMaxId()?0:personRepository.findByMaxId()+1);
                personRepository.save(person);
                return "Person record created successfully";
            }else{
                return "Person record already exists";
            }
        }catch(Exception e){
            throw e;
        }
    }

    public List<Person> readPersons(){
        return personRepository.findAll();
    }
}