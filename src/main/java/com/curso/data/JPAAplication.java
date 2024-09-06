package com.curso.data;

import com.curso.data.entities.Transaction;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class JPAAplication {
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

            // select t from transaction t
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Transaction> criteriaQuery = cb.createQuery(Transaction.class);

            Root<Transaction> root = criteriaQuery.from(Transaction.class);
            Path<BigDecimal> amountPath = root.get("amount");
            Path<String> transactionTypePath = root.get("transactionType");

            criteriaQuery.select(root).where(cb.and(cb.le(amountPath, new BigDecimal("20.00"))));

            TypedQuery<Transaction> query = em.createQuery(criteriaQuery);
            List<Transaction> transactions = query.getResultList();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
            factory.close();
        }
    }
}