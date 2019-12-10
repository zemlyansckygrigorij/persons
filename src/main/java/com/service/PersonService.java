package com.service;

import com.entity.Person;
import java.util.List;

public interface PersonService {
    public void add(Person person);
    public void update(Person person);
    public void remove(int id);
    public Person get(int id);
    public List<Person> list();
}
