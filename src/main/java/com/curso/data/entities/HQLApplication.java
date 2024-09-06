package com.curso.data.entities;

import com.curso.data.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class HQLApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SessionFactory facotry = null;
        Session session = null;
        Transaction tx = null;

        try {
            facotry = HibernateUtil.getSessionFactory();
            session = facotry.openSession();
            tx = session.beginTransaction();


            Query query = session.getNamedQuery("Account.largeDeposits");
            List<Account> accounts = query.list();

            for (Account a : accounts) {
                System.out.println(a.getName());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();

        } finally {
            session.close();
            facotry.close();
        }
    }
}
