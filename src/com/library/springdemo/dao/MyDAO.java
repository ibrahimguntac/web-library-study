package com.library.springdemo.dao;

import com.library.springdemo.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ibrahimg on 09.01.2019.
 */
@Component
public class MyDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Book> getBooks() {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // create the query
        Query query = currentSession.createQuery("from Book", Book.class);

        // execute the query and result list
        List<Book> bookList = query.getResultList();

        // return the result
        return bookList;
    }
}
