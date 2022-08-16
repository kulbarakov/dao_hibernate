package ru.netology.daohibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daohibernate.repository.PersonRepository;

@RestController
public class PersonController {

    @Autowired
    PersonRepository repository;

    @GetMapping("/persons/by-city")
    public String getPersons(@RequestParam("city") String city) {
        return repository.getPersonsByCity(city).toString();
    }
    @GetMapping("/persons/add")
    public void addData() {
        repository.addDataToBase();
    }
}
