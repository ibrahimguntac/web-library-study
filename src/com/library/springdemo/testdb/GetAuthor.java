package com.library.springdemo.testdb;

import com.library.springdemo.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by ibrahimg on 07.11.2018.
 */
public class GetAuthor {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate-config.xml").addAnnotatedClass(Author.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            List<Author> list = session.createQuery("from Author", Author.class).getResultList();
            for (int i = 0; i< list.size(); i++){
                System.out.println("\n" + list.get(i).getAuthorName() +  " - " + list.get(i).getAuthorLastName()
                                   + " - " + list.get(i).getBirthDate() + " - " + list.get(i).getDeathDate() + "\n");
            }
            session.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
