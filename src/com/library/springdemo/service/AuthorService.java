package com.library.springdemo.service;

import com.library.springdemo.entity.Author;

import java.util.List;

/**
 * Created by ibrahimg on 08.11.2018.
 */
public interface AuthorService {

    List<Author> getAuthors();

    void saveAuthor(Author theAuthor);

    Author getAuthors(int theId);

    void deleteAuthor(int theId);

    List<Author> searchAuthor(String searchNameAndSurname);

    List<Author> getAuthorsForBook(int theId);
}
