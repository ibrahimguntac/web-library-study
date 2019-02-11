package com.library.springdemo.dao;

import com.library.springdemo.entity.Author;

import java.util.List;

/**
 * Created by ibrahimg on 07.11.2018.
 */

public interface AuthorDAO {

    List<Author> getAuthors();

    void saveAuthor(Author theAuthor);

    Author getAuthors(int theId);

    void deleteAuthor(int theId);

    List<Author> searchAuthors(String searchNameAndSurname);

    List<Author> getAuthorsForBook(int theId);
}
