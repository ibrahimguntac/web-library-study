package com.library.springdemo.webservice;

import com.library.springdemo.entity.Book;
import com.library.springdemo.service.BookService;
import com.library.springdemo.service.BookServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by ibrahimg on 08.01.2019.
 */
@Service
@WebService (endpointInterface = "com.library.springdemo.webservice.TestWS")
public class TestWS extends SpringBeanAutowiringSupport {

    @Autowired
    private BookService bookService;

    @WebMethod
    public List<Book> bookList(){
        return bookService.getBooks();
    }
}
