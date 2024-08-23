package com.curso.data.entities;

import com.curso.data.HibernateUtil;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public class Application {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            org.hibernate.Transaction transaction = session.beginTransaction();
            Account account = new Account();
            account.getTransactions().add(createNewBeltPurchase(account));
            account.getTransactions().add(createShoePurchase(account));

            session.persist(account);
            transaction.commit();

            Transaction dbTransaction = session.get(Transaction.class, account.getTransactions().get(0).getTransactionId());
            System.out.println(dbTransaction.getAccount().getName());

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
    private static com.curso.data.entities.Transaction createNewBeltPurchase(Account account) {
        com.curso.data.entities.Transaction beltPurchase = new com.curso.data.entities.Transaction();
        beltPurchase.setAccount(account);
        beltPurchase.setTitle("Dress Belt");
        beltPurchase.setAmount(new BigDecimal("50.00"));
        beltPurchase.setClosingBalance(new BigDecimal("0.00"));
        beltPurchase.setCreatedBy("Kevin Bowersox");
        beltPurchase.setCreatedDate(new Date());
        beltPurchase.setInitialBalance(new BigDecimal("0.00"));
        beltPurchase.setLastUpdatedBy("Kevin Bowersox");
        beltPurchase.setLastUpdatedDate(new Date());
        beltPurchase.setNotes("New Dress Belt");
        beltPurchase.setTransactionType("Debit");
        return beltPurchase;
    }

    private static com.curso.data.entities.Transaction createShoePurchase(Account account) {
        com.curso.data.entities.Transaction shoePurchase = new com.curso.data.entities.Transaction();
        shoePurchase.setAccount(account);
        shoePurchase.setTitle("Work Shoes");
        shoePurchase.setAmount(new BigDecimal("100.00"));
        shoePurchase.setClosingBalance(new BigDecimal("0.00"));
        shoePurchase.setCreatedBy("Kevin Bowersox");
        shoePurchase.setCreatedDate(new Date());
        shoePurchase.setInitialBalance(new BigDecimal("0.00"));
        shoePurchase.setLastUpdatedBy("Kevin Bowersox");
        shoePurchase.setLastUpdatedDate(new Date());
        shoePurchase.setNotes("Nice Pair of Shoes");
        shoePurchase.setTransactionType("Debit");
        return shoePurchase;
    }

    private static Account createNewAccount() {
        Account account = new Account();
        account.setCloseDate((java.sql.Date) new Date());
        account.setOpenDate((java.sql.Date) new Date());
        account.setCreatedBy("Kevin Bowersox");
        account.setInitialBalance(new BigDecimal("50.00"));
        account.setName("Savings Account");
        account.setCurrentBalance(new BigDecimal("100.00"));
        account.setLastUpdatedBy("Kevin Bowersox");
        account.setLastUpdatedDate((java.sql.Date) new Date());
        account.setCreatedDate((java.sql.Date) new Date());
        return account;
    }


}
