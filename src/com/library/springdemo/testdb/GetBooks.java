package com.library.springdemo.testdb;

import com.library.springdemo.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.SourceType;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibrahimg on 02.11.2018.
 */
public class GetBooks {

    public static void main(String[] args) {

        // session factory
        SessionFactory sessionFactory = new Configuration().configure("hibernate-config.xml").addAnnotatedClass(Book.class).buildSessionFactory();

        // session
        Session session = sessionFactory.getCurrentSession();

        try {
            // begin transaction
            session.beginTransaction();



            List<Book> bookList = session.createQuery("from Book", Book.class).getResultList();
            for(int i = 0; i< bookList.size(); i++){
                System.out.println(bookList.get(i).getBookName() + "-" + bookList.get(i).getBookType());
            }

            // commit transaction
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // close factory and session
            session.close();
            sessionFactory.close();
        }

    }

}
