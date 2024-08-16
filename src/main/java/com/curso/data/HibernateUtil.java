package com.curso.data;

import com.curso.data.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(User.class);
            return configuration.
                    buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
