package com.dao;

import com.entity.Person;
import com.service.HibernateUtil;
import com.service.PersonService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PersonDao implements PersonService {
    @Override
    public void add(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(person);
            tx.commit();
        }catch(HibernateException e){
            if(tx !=null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Override
    public void update(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            session.update(person);
            tx.commit();
        }catch(HibernateException e ){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Override
    public void remove(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            session.delete(get(id));
            tx.commit();
        }catch(HibernateException e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
    }

    @Override
    public Person get(int id) {
        return (Person) HibernateUtil.getSessionFactory().openSession().get(Person.class, id);
    }

    @Override
    public List<Person> list() {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        List<Person> persons = session.createQuery("From Person").list();
        return persons ;
    }
}
