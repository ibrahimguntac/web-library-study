package com.library.springdemo.testdb;

import com.library.springdemo.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by ibrahimg on 02.11.2018.
 */
public class CreateBook {

    public static void main(String[] args) {


        // session facatory
        SessionFactory sessionFactory = new Configuration().configure("hibernate-config.xml").addAnnotatedClass(Book.class).buildSessionFactory();

        // session
        Session session = sessionFactory.getCurrentSession();

        try {
            // begin transaction
            session.beginTransaction();

            Book book1 = new Book("Fareler ve İnsanlar", "Roman");
            Book book2 = new Book("Nutuk", "Biyografi");
            Book book3 = new Book("Fareli Koyun Kavalcisi", "Oyku");

            session.save(book1);
            session.save(book2);
            session.save(book3);

            // commit transaction
            session.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // session and factory close
            session.close();
            sessionFactory.close();
        }

    }

}
