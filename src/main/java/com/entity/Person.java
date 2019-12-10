package com.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id",updatable = false, nullable = false)
    private long id;

    @Column(name= "first_name")
    private String firstName;

    @Column(name= "last_name")
    private String  lastName;

    @Column(name= "date_birth")
    private Date dateBirth;

    @Column(name= "marriage")
    private int marriageInt;

    private boolean marriage;

    @Column(name= "balance")
    private double balance;

    public Person() { }

    public long getId() {
        return id;
    }

    private void setId(long id) {
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

    public int getMarriageInt() {
        return marriageInt;
    }

    private void setMarriageInt(int marriageInt) {
        this.marriageInt = marriageInt;
    }

    public boolean isMarriage() {
        return marriage;
    }

    public void setMarriage(boolean marriage) {
        this.marriage = marriage;
        if(marriage){
            setMarriageInt(1);
        }else{
            setMarriageInt(0);
        }
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
