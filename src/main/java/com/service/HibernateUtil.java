package com.service;

import com.entity.Person;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private HibernateUtil(){}

    private static SessionFactory sessionFactory;

    static{
        Configuration cfg = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(cfg.getProperties());
        cfg.addAnnotatedClass(Person.class);
        sessionFactory = cfg.buildSessionFactory(builder.build());
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
