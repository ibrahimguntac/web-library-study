package com.library.springdemo.dao;

import com.library.springdemo.entity.Author;
import com.library.springdemo.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibrahimg on 07.11.2018.
 */
@Repository
public class AuthorDAOImp implements AuthorDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Author> getAuthors() {

        // get current session
        Session currentSession = sessionFactory.getCurrentSession();

        // create a query
        Query query = currentSession.createQuery("from Author", Author.class);

        // execute the list
        List<Author> authorList = query.getResultList();

        // return list
        return authorList;
    }

    @Override
    public void saveAuthor(Author theAuthor) {

        Session currentSession = sessionFactory.getCurrentSession();

        theAuthor.setBooks(new ArrayList<>());
        currentSession.saveOrUpdate(theAuthor);
    }

    @Override
    public Author getAuthors(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();
        Author author = currentSession.get(Author.class, theId);
        return author;
    }

    @Override
    public void deleteAuthor(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from Author where id = :theId");
        query.setParameter("theId", theId);
        query.executeUpdate();
    }

    @Override
    public List<Author> searchAuthors(String searchNameAndSurname) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = null;

        // only search by name if searchName is not empty
        if(searchNameAndSurname != null && searchNameAndSurname.trim().length() > 0){

            // search for firstName or lastName ... case insensitive
            query = currentSession.createQuery("from Author where (lower(authorName) like :theName or lower(authorLastName) like :theName)", Author.class);
            query.setParameter("theName", "%" + searchNameAndSurname.toLowerCase() + "%");
        }else {

            // searchName is empty ... so just get all customers
            query = currentSession.createQuery("from Author", Author.class);
        }

        // execute the query and result list
        List<Author> authorList = query.getResultList();

        // return the result
        return authorList;
    }

    @Override
    public List<Author> getAuthorsForBook(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createNativeQuery("select AUTHOR_NAME, AUTHOR_LAST_NAME   \n" +
                "from book b, author a, book_author ba\n" +
                "where b.BOOK_ID = :theId and b.BOOK_ID = ba.BOOK_ID and a.AUTHOR_ID = ba.AUTHOR_ID");
        query.setParameter("theId", theId);

        List<Object> objList = query.list();
        List<Author> authorList = new ArrayList<>(objList.size());
        for(Object obj : objList){
            Object[] objArr = (Object[]) obj;
            Author author = new Author();
            author.setAuthorName(objArr[0].toString());
            author.setAuthorLastName(objArr[1].toString());
            authorList.add(author);
        }

        return authorList;
    }
}
