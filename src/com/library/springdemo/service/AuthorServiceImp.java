package com.library.springdemo.service;

import com.library.springdemo.dao.AuthorDAO;
import com.library.springdemo.entity.Author;
//import com.library.springdemo.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created by ibrahimg on 08.11.2018.
 */
@Service
public class AuthorServiceImp implements AuthorService {

    @Autowired
    private AuthorDAO authorDAO;

    @Override
    @Transactional
    public List<Author> getAuthors() {
        return authorDAO.getAuthors();
    }

    @Override
    @Transactional
    public void saveAuthor(Author theAuthor) {
        authorDAO.saveAuthor(theAuthor);
    }

    @Override
    @Transactional
    public Author getAuthors(int theId) {
        return authorDAO.getAuthors(theId);
    }

    @Override
    @Transactional
    public void deleteAuthor(int theId) {
        authorDAO.deleteAuthor(theId);
    }

    @Override
    @Transactional
    public List<Author> searchAuthor(String searchNameAndSurname) {
        return authorDAO.searchAuthors(searchNameAndSurname);
    }

    @Override
    @Transactional
    public List<Author> getAuthorsForBook(int theId) {
        return authorDAO.getAuthorsForBook(theId);
    }
}
