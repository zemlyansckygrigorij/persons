package com.dao;

import com.entity.Person;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class PersonDaoTest {
    Person person;
    PersonDao personDao = new PersonDao();
    {
        person = new Person();
        person.setBalance(11.23d);
        person.setFirstName("1");
        person.setLastName("1");
        person.setMarriage(true);
        person.setBalance(123d);
        person.setDateBirth(new Date());
    }

    @Test
    public void listTest() {

        try{
            System.out.println( "check listTest ");
            List<Person> persons =  personDao.list();
            assertNotNull(persons);
            System.out.println( "check true");
        }catch(Exception e ){
            System.out.println( "check false");
            e.printStackTrace();
        }
    }
    @Test
    public void addTest(){

        try{
            System.out.println( "check add() ");
            int size =  personDao.list().size();
            personDao.add(person);
            assertEquals(size+1,personDao.list().size());
            System.out.println( "check true");

            Person personFromTable = personDao.list().get(size);

            System.out.println( "check personFromTable is Exist");
            assertNotNull(personFromTable);
            System.out.println( "check true");

            System.out.println( "check personFromTable .getMarriage()");
            assertEquals(personFromTable.getMarriage(),person.getMarriage());
            System.out.println( "check true");

            System.out.println( "check personFromTable .getBalance()");
            assertEquals(personFromTable.getBalance(),person.getBalance(),0.0d);
            System.out.println( "check true");

            System.out.println( "check personFromTable .getDateBirth()");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateBirthPersonFromTable = personFromTable.getDateBirth();
            Date dateBirthPerson = person.getDateBirth();
            assertEquals(sdf.format(dateBirthPersonFromTable),sdf.format(dateBirthPerson ));
            System.out.println( "check true");

            System.out.println( "check personFromTable .getFirstName()");
            assertEquals(personFromTable.getFirstName(),person.getFirstName());
            System.out.println( "check true");

            System.out.println( "check personFromTable .getLastName()");
            assertEquals(personFromTable.getLastName(),person.getLastName());
            System.out.println( "check true");

        }catch(Exception e ){
            System.out.println( "check false");
            e.printStackTrace();
        }

    }
    @Test
    public void getTest(){
        System.out.println( "check get ");
        try{
            List<Person> persons =  personDao.list();
            for(Person person: persons){
                Person personFromTable = personDao.get(person.getId());
                System.out.println( "check personFromTable is Exist");
                assertNotNull(personFromTable);
                System.out.println( "check true");

                System.out.println( "check personFromTable .getMarriage()");
                assertEquals(personFromTable.getMarriage(),person.getMarriage());
                System.out.println( "check true");

                System.out.println( "check personFromTable .getBalance()");
                assertEquals(personFromTable.getBalance(),person.getBalance(),0.0d);
                System.out.println( "check true");

                System.out.println( "check personFromTable .getDateBirth()");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date dateBirthPersonFromTable = personFromTable.getDateBirth();
                Date dateBirthPerson = person.getDateBirth();
                assertEquals(sdf.format(dateBirthPersonFromTable),sdf.format(dateBirthPerson ));
                System.out.println( "check true");

                System.out.println( "check personFromTable .getFirstName()");
                assertEquals(personFromTable.getFirstName(),person.getFirstName());
                System.out.println( "check true");

                System.out.println( "check personFromTable .getLastName()");
                assertEquals(personFromTable.getLastName(),person.getLastName());
                System.out.println( "check true");
            }
        }catch(Exception e ){
            System.out.println( "check false");
            e.printStackTrace();
        }
    }
    @Test
    public void updateTest(){
        System.out.println( "check updateTest ");
        try{
            int size =  personDao.list().size();
            personDao.add(person);
            Person personFromTable = personDao.list().get(size-1);
            personFromTable.setBalance(19.23d);
            personFromTable.setFirstName("19");
            personFromTable.setLastName("9");
            personFromTable.setMarriage(false);
            personFromTable.setBalance(124d);
            personFromTable.setDateBirth(new Date(100));

            personDao.update(personFromTable);
            Person personFromTableNew = personDao.get(personFromTable.getId());

            System.out.println( "check personFromTableNew is Exist");
            assertNotNull(personFromTableNew);
            System.out.println( "check true");

            System.out.println( "check personFromTable .getMarriage()");
            assertEquals(personFromTable.getMarriage(),personFromTableNew.getMarriage());
            System.out.println( "check true");

            System.out.println( "check personFromTable .getBalance()");
            assertEquals(personFromTable.getBalance(),personFromTableNew.getBalance(),0.0d);
            System.out.println( "check true");

            System.out.println( "check personFromTable .getDateBirth()");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateBirthPersonFromTable = personFromTable.getDateBirth();
            Date dateBirthPerson = personFromTableNew.getDateBirth();
            assertEquals(sdf.format(dateBirthPersonFromTable),sdf.format(dateBirthPerson ));
            System.out.println( "check true");

            System.out.println( "check personFromTable .getFirstName()");
            assertEquals(personFromTable.getFirstName(),personFromTableNew.getFirstName());
            System.out.println( "check true");

            System.out.println( "check personFromTable .getLastName()");
            assertEquals(personFromTable.getLastName(),personFromTableNew.getLastName());
            System.out.println( "check true");
        }catch(Exception e ){
            System.out.println( "check false");
            e.printStackTrace();
        }
    }
    @Test
    public void removeTest(){
        System.out.println( "check removeTest ");
        try{
            int size =  personDao.list().size();
            if(size<1){
                return;
            }
            Person personFromTable = personDao.list().get(size-1);
            personDao.remove(personFromTable.getId());
            Person personFromTableNew = personDao.get(personFromTable.getId());
            System.out.println( "check personFromTableNew is Null");
            assertNull(personFromTableNew);
            System.out.println( "check true");
        }catch(Exception e ){
            System.out.println( "check false");
            e.printStackTrace();
        }
    }

    @Test
    public void allTest(){
        listTest();
        addTest();
        getTest();
        updateTest();
        removeTest();
    }
}
