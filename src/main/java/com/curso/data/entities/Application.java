package com.curso.data.entities;

import com.curso.data.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Calendar;
import java.util.Date;

public class Application {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Transaction transaction = session.beginTransaction();
            Bank bank = new Bank();
            bank.setName("Federal Trust");
            bank.getAddress().setAddressLine1("33 Wall Street");
            bank.getAddress().setAddressLine2("Suite 302");
            bank.getAddress().setCity("New York");
            bank.getAddress().setState("NY");
            bank.getAddress().setZipCode("27914");
            bank.setCreatedBy("Kevin Bowersox");
            bank.setCreatedDate(new Date());
            bank.setLastUpdatedBy("Kevin Bowersox");
            bank.setLastUpdatedDate(new Date());
            bank.setInternational(false);

            session.persist(bank);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.getSessionFactory().close();
        }

    }

    private static Date getMyBirthDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1984);
        calendar.set(Calendar.MONTH, 6);
        calendar.set(Calendar.DATE, 19);
        return calendar.getTime();
    }

    //            session.getTransaction().begin();
//            User user = new User();
//            user.setBirthDate(getMyBirthDay());
//            user.setCreatedBy("kevin");
//            user.setCreatedDate(new Date());
//            user.setEmailAddress("kmb385@yahoo.com.br");
//            user.setFirstName("Kevin");
//            user.setLastName("Bowersox");
//            user.setLastUpdatedBy("kevin");
//            user.setLastUpdatedDate(new Date());
}
