package com.library.springdemo.service;

import com.library.springdemo.dao.MyDAO;
import com.library.springdemo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ibrahimg on 09.01.2019.
 */
@Service
public class MyService {

    @Autowired
    private MyDAO myDAO;

    public List<Book> getBooks() {
        return myDAO.getBooks();
    }

}
