package com.curso.data.entities;

import com.curso.data.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

public class Application {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        User user = new User();
        user.setBirthDate(new Date());
        user.setCreatedBy("kevin");
        user.setEmailAddress("kmb385@yahoo.com.br");
        user.setFirstName("Kevin");
        user.setLastName("Bowersox");
        user.setLastUpdatedBy("kevin");
        user.setLastUpdatedDate(new Date());
        user.setCreatedDate(new Date());
        session.persist(user);

        session.getTransaction().commit();
        session.close();
    }
}
