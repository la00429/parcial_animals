package co.edu.uptc.people_rest.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import co.edu.uptc.people_rest.services.PeopleService;



@RestController
@RequestMapping("/people")
public class PeopleController {
   @Autowired
    private PeopleService peopleService; 


    @GetMapping("/range")
    public List<String> getNombres(@RequestParam int from, @RequestParam int to) throws IOException {
        return peopleService.getPersonInRange(from, to);
    }


}
