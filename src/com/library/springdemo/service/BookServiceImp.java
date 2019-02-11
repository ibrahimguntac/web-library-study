package com.library.springdemo.service;

import com.library.springdemo.dao.BookDAO;
import com.library.springdemo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by ibrahimg on 02.11.2018.
 */
@Service
public class BookServiceImp  implements BookService{

    // need to inject book dao
    @Autowired
    private BookDAO bookDAO;

    public List<Book> getAllBooks() {
        return bookDAO.getBooks();
    }

    @Override
    @Transactional
    public List<Book> getBooks() {
        return bookDAO.getBooks();
    }

    @Override
    @Transactional
    public void saveBook(Book theBook) {
        bookDAO.saveBook(theBook);
    }

    @Override
    @Transactional
    public Book getBooks(int theId) {

        return bookDAO.getBooks(theId);
    }

    @Override
    @Transactional
    public void deleteBook(int theId) {
        bookDAO.deleteBook(theId);
    }

    @Override
    @Transactional
    public List<Book> searchBook(String searchName) {
        return bookDAO.searchBook(searchName);
    }

    @Override
    @Transactional
    public List<Book> getBooksForAuthor(int theId) {
        return bookDAO.getBooksForAuthor(theId);
    }

}
