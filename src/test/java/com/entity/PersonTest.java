package com.entity;

import org.junit.Test;

import org.junit.jupiter.api.DisplayName;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;

public class PersonTest {

    @Test
    public void createPerson(){
        try{
            System.out.println( "Check create Person");
            Person person = new Person();
            assertNotNull(person);
            System.out.println( "check true");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println( "check false");
        }
    }
    @Test
    public void idTest(){
        try{
            System.out.println( "Check id");
            Person person = new Person();
            assertEquals(0,person.getId());
            System.out.println( "check true");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println( "check false");
        }
    }
    @Test
    public void firstNameTest(){
        try{
            System.out.println( "Check firstName");
            Person person = new Person();
            person.setFirstName("person");
            assertEquals("person",person.getFirstName());
            System.out.println( "check true");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println( "check false");
        }
    }
    @Test
    public void lastNameTest(){
        try{
            System.out.println( "Check lastName");
            Person person = new Person();
            person.setLastName("person");
            assertEquals("person",person.getLastName());
            System.out.println( "check true");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println( "check false");
        }
    }

    @Test
    public void dateBirthTest(){
        try{
            System.out.println( "Check DateBirth");
            Person person = new Person();
            Date date = new Date();
            person.setDateBirth(date);
            assertEquals(date,person.getDateBirth());
            System.out.println( "check true");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println( "check false");
        }
    }
    @Test
    public void marriageTest(){
        try{
            System.out.println( "Check Marriage");
            Person person = new Person();

            person.setMarriage(true);
            System.out.println( "check MarriageInt, except 1");
            assertEquals(new Integer(1),person.getMarriage());
            System.out.println( "check true");





            person.setMarriage(false);
            System.out.println( "check Marriage, except false");
            assertEquals(new Integer(0),person.getMarriage());
            System.out.println( "check true");

        }catch(Exception e){
            e.printStackTrace();
            System.out.println( "check false");
        }
    }

    @Test
    public void balanceTest(){
        try{
            System.out.println( "Check Balance");
            Person person = new Person();

            person.setBalance(11.23d);
            assertEquals(11.23d,person.getBalance(),0.0d);
            System.out.println( "check true");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println( "check false");
        }
    }

    @Test
    public void equalsTest(){
        try{
            System.out.println( "Check equals");
            Person personOne = new Person();
            personOne.setBalance(11.23d);
            personOne.setFirstName("1");
            personOne.setLastName("1");
            personOne.setMarriage(true);
            personOne.setBalance(123d);
            personOne.setDateBirth(new Date(100));

            Person personTwo = new Person();
            personTwo.setBalance(13.23d);
            personTwo.setFirstName("4");
            personTwo.setLastName("4");
            personTwo.setMarriage(false);
            personTwo.setBalance(234d);
            personTwo.setDateBirth(new Date(13333));

            assertEquals(personOne,personTwo);
            System.out.println( "check true");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println( "check false");
        }
    }
    @Test
    public void allTestPerson(){
        createPerson();
        idTest();
        firstNameTest();
        lastNameTest();
        dateBirthTest();
        marriageTest();
        balanceTest();
        equalsTest();
    }
}

