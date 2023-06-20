package org.javarush.repository.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javarush.entity.Office;
import org.javarush.utils.EntityScanner;

public enum SessionCreator implements AutoCloseable {
    INSTANCE;

    private final SessionFactory sessionFactory;
    SessionCreator(){
        Configuration config = new Configuration();
        config.configure();
//        config.addAnnotatedClass(Office.class);
        EntityScanner.getEntities().forEach(config::addAnnotatedClass);

        sessionFactory = config.buildSessionFactory();
    }

    public static SessionCreator getInstance() {
        return INSTANCE;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }


    @Override
    public void close() throws Exception {
        sessionFactory.close();
    }
}
