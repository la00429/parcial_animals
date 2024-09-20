package co.edu.uptc.people_rest.controllers;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import co.edu.uptc.people_rest.services.PeopleService;



@RestController
@RequestMapping("/people")
public class PeopleController {

 private static final Logger logger = LoggerFactory.getLogger(PeopleController.class);

   @Autowired
    private PeopleService peopleService; 


    @GetMapping("/range")
    public List<String> getNombres(@RequestParam int from, @RequestParam int to) throws IOException {
        logger.info("getNombres called with parameters: from = {}, to = {}", from, to);
        return peopleService.getPersonInRange(from, to);
    }


}
