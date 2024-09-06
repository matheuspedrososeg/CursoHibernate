package com.curso.data.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class JPQLApplication {
    public static void main(String[] args) {
        EntityManagerFactory factory = null;
        EntityManager em = null;
        EntityTransaction tx = null;

        try {
            Scanner scanner = new Scanner(System.in);
            factory = Persistence.createEntityManagerFactory("maeda-sys");
            em = factory.createEntityManager();
            tx = em.getTransaction();
            tx.begin();

            Query query = em.createQuery("select distinct t.account.name, t.account.bank.address.state " +
                    "from Transaction t join t.account a where t.amount > 500 and t.transactionType = 'Deposit'");


            List<Object[]> accounts = query.getResultList();

            for (Object[] a : accounts) {
                System.out.println(a[0]);
                System.out.println(a[1]);
            }

            tx.commit();
        }  catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            factory.close();
        }
    }
}
