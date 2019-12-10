package com.service;


import org.hibernate.SessionFactory;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class HibernateUtilTest {

    @Test
    public void getSessionFactoryTest(){
        try{
            System.out.println("check SessionFactory");
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            assertNotNull(sessionFactory);
            System.out.println("SessionFactory is exist");
        }catch(Exception e ){
            System.out.println("SessionFactory is not exist");
            e.printStackTrace();
        }

    }
}

