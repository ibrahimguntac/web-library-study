package com.library.springdemo.testdb;

import com.library.springdemo.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.validation.constraints.Pattern;
import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * Created by ibrahimg on 07.11.2018.
 */
public class CreateAuthor {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate-config.xml").addAnnotatedClass(Author.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Author author = new Author("Halide Edip", "Adivar", "10-04-1913", "16-06-1992");
            Author author1 = new Author("Johann Wolfgang", "von Goethe", "22-08-1749", "22-03-1832");
            Author author2 = new Author("Reşat Nuri", "Güntekin", "25-11-1889", "07-12-1956");
            Author author3 = new Author("Peyami", "Safa", "02-04-1899", "15-06-1961");

            session.save(author);
            session.save(author1);
            session.save(author2);
            session.save(author3);

            session.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }

//        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^\\s*(3[01]|[12][0-9]|0?[1-9])\\-(1[012]|0?[1-9])\\-((?:19|20)\\d{2})\\s*$");
//        Matcher matcher = pattern.matcher("parametre");
//
//        if (!matcher.find()){
//            throw new RuntimeException("Tarih hatalı (dd-MM-yyyy) ");
//        }else{
//            System.out.println("Başarılı");
//        }

    }
}
