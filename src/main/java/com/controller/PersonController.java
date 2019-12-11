package com.controller;

import com.dao.PersonDao;
import com.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

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
    public String getAccountById(@PathVariable String id, Map<String,Object> model){
        Person person = null;
        int idPath = 0 ;
        try{
            idPath = Integer.valueOf(id)  ;
            person = personDao.get(idPath);
            model.put("person", person);
            return "person";
        }catch(Exception e){
            e.printStackTrace();
            return "pageNotFound";
        }
    }
}
