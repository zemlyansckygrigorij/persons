package com.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name="persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id",updatable = false, nullable = false)
    private int id;

    @Column(name= "first_name")
    private String firstName;

    @Column(name= "last_name")
    private String  lastName;

    @Column(name= "date_birth")
    private Date dateBirth;

    @Column(name= "marriage")
    private Integer marriage;

    public Integer getMarriage() {
        return marriage;
    }

    public void setMarriage(boolean bool) {
        if(bool){
            this.marriage = 1;
        }else{
            this.marriage = 0;
        }

    }



    @Column(name= "balance")
    private double balance;

    public Person() { }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getId() == person.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
