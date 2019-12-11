package com.controller;

import com.dao.PersonDao;
import com.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class PersonController {
    PersonDao personDao = new PersonDao();

    @GetMapping(path ="/")
    @ResponseBody
    public String getHelloWorld(){
        return "hello world";
    }

    @GetMapping(path ="/persons")
    public String getPersonsList(Map<String,Object> model){
        model.put("persons",personDao.list());
        return "persons";
    }

    @GetMapping(path="/persons/{id}")
    public String getPersonById(@PathVariable String id, Map<String,Object> model){

        try{
            int idPath = Integer.valueOf(id)  ;
            /*
            personDao.list().stream()                // convert list to stream
                    .filter(person -> person.getId()==idPath)     // we dont like mkyong
                    .collect(Collectors.toList()).get(0);
                    */
            model.put("person",personDao.list().stream()                // convert list to stream
                    .filter(person -> person.getId()==idPath)     // we dont like mkyong
                    .findAny());
                  //  .get(0));
            return "person";
        }catch(Exception e){
            e.printStackTrace();
            return "pageNotFound";
        }
    }
}
