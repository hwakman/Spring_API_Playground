package dev.application.person;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/get_all")
    public List<Person> getAllPerson() {
        List<Person> persons = new ArrayList<>();
        personRepository.findAll().forEach(persons::add);
        return persons;
    }

    @GetMapping("/get_id")
    public Person getIdPerson (@RequestParam(value = "id") Long id) {
        Person persons = new Person();
        persons = personRepository.findById(id).get();

        return persons;
    }

    @GetMapping("/get_first_name")
    public List<Person> getFirstName (@RequestParam(value = "first_name") String fName) {
        List<Person> persons = new ArrayList<>();
        personRepository.findByFirstName(fName).forEach(persons::add);
        return persons;
    }

    @GetMapping("/get_last_id")
    public Long getLastId () {
        return personRepository.getLastId();
    }

    @PostMapping("/add_person")
    public String setPerson (@RequestParam(value = "first_name") String firstname, @RequestParam(value = "last_name") String lastname) {
        try {
            Person person = new Person();
            person.setFirst_name(firstname);
            person.setLast_name(lastname);
            personRepository.save(person);
            return "Value added";
        } catch (Exception e) {
            return "error : " + e;
        }
    }
}