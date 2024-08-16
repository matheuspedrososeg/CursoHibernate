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
            User user = new User();
            Credential credential = new Credential();
            setUserFields(user);

            session.persist(user);
            transaction.commit();

            User dbuser = session.get(User.class, credential.getUser().getUserId());
            System.out.println(dbuser.getFirstName());

        } catch (Exception e) {
            System.out.println(e.getMessage());
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
    private static void setAddressFields(Address address) {
        address.setAddressLine1("line 1");
        address.setAddressLine2("line 2");
        address.setCity("New York");
        address.setState("NY");
        address.setZipCode("12345");
    }
    private static void setAddressFields2(Address address) {
        address.setAddressLine1("line 1");
        address.setAddressLine2("line 2");
        address.setCity("Corning");
        address.setState("NY");
        address.setZipCode("12345");
    }
    private static void setUserFields(User user) {
        user.setBirthDate(getMyBirthDay());
        user.setCreatedBy("kevin");
        user.setCreatedDate(new Date());
        user.setEmailAddress("kmb385@yahoo.com.br");
        user.setFirstName("Kevin");
        user.setLastName("Bowersox");
        user.setLastUpdatedBy("kevin");
        user.setLastUpdatedDate(new Date());
    }

}
