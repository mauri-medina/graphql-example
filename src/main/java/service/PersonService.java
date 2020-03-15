package service;

import dao.PersonRepository;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAllPersons(){
        return personRepository.findAll();
    }

    public Person findPerson(Integer id){
        return personRepository.findById(id).get();
    }

    public Person createPerson(String firstName, String lastName){
        Person person = new Person(firstName, lastName);
        return personRepository.save(person);
    }

    public Boolean deletePerson(Integer id){
        Person person = new Person(id);
        personRepository.delete(person);
        return Boolean.TRUE;
    }

    public Person updatePerson(Integer id, String firstName, String lastName){
        // Find Person
        Person person = personRepository.findById(id).orElseThrow(NoSuchElementException::new);

        // Update Person
        if(firstName != null && !firstName.isEmpty()){
            person.setFirstName(firstName);
        }

        if(lastName != null && !lastName.isEmpty()){
            person.setFirstName(lastName);
        }

        return personRepository.save(person);
    }
}
