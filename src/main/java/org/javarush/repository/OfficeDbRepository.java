package org.javarush.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.javarush.entity.Office;
import org.javarush.repository.hibernate.SessionCreator;

import java.util.List;

@RequiredArgsConstructor
public class OfficeDbRepository implements Repository<Office>{
    private final SessionCreator sessionCreator;

    @Override
    public Office findById(long id) {
        Session session = sessionCreator.getSession();
        Office office = null;

        try (session) {
            Transaction tx = session.beginTransaction();
            try {
                office = session.get(Office.class, String.valueOf(id));
                tx.commit();
            }catch (Exception e){
                tx.rollback();
            }
        }
        return office;
    }

    @Override
    public List<Office> findAll() {
        return null;
    }

    @Override
    public void create(Office entity) {
        Session session = sessionCreator.getSession();

        try (session) {
            Transaction tx = session.beginTransaction();
            try {
                session.persist(entity);
                tx.commit();
            }catch (Exception e){
                tx.rollback();
            }
        }
    }

    @Override
    public void update(Office entity) {
        Session session = sessionCreator.getSession();

        try (session) {
            Transaction tx = session.beginTransaction();
            try {
                session.merge(entity);
                tx.commit();
            }catch (Exception e){
                tx.rollback();
            }
        }
    }

    @Override
    public void delete(Office entity) {
        Session session = sessionCreator.getSession();

        try (session) {
            Transaction tx = session.beginTransaction();
            try {
                session.remove(entity);
                tx.commit();
            }catch (Exception e){
                tx.rollback();
            }
        }
    }
}
