package com.library.springdemo.testdb;

import com.library.springdemo.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibrahimg on 14.11.2018.
 */
public class Native {
    public static void main(String[] args) {
        // session facatory
        SessionFactory sessionFactory = new Configuration().configure("hibernate-config.xml").addAnnotatedClass(Book.class).buildSessionFactory();

        // session
        Session session = sessionFactory.getCurrentSession();

        int theId = 10;
        try {
            // begin transaction
            session.beginTransaction();

            Session currentSession = sessionFactory.getCurrentSession();
            Query query = currentSession.createQuery("select BOOK_NAME, BOOK_TYPE   \n" +
                    "from book b, author a, book_author ba\n" +
                    "where a.AUTHOR_ID = :theId and b.BOOK_ID = ba.BOOK_ID and a.AUTHOR_ID = ba.AUTHOR_ID");
            query.setParameter("theId", theId);
            List<Object> objectList = query.getResultList();
            List<Book> bookList = new ArrayList<>();
            for (Object obj : objectList) {
                Book book = new Book();

                // commit transaction
                session.getTransaction().commit();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // session and factory close
            session.close();
            sessionFactory.close();
        }
    }

}

