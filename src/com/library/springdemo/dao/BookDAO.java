package com.library.springdemo.dao;

import com.library.springdemo.entity.Book;

import java.util.List;

/**
 * Created by ibrahimg on 02.11.2018.
 */
public interface BookDAO {

    List<Book> getBooks();

    void saveBook(Book theBook);

    Book getBooks(int theId);

    void deleteBook(int theId);

    List<Book> searchBook(String searchName);

    List<Book> getBooksForAuthor(int theId);
}
