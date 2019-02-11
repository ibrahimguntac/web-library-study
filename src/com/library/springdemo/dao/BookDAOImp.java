package com.library.springdemo.dao;

import com.library.springdemo.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibrahimg on 02.11.2018.
 */

@Component
public class BookDAOImp implements BookDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
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

    @Override
    public void saveBook(Book theBook) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(theBook);
    }

    @Override
    public Book getBooks(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Book theBook = currentSession.get(Book.class, theId);

        return theBook;
    }

    @Override
    public void deleteBook(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("delete from Book where id = :theId");
        query.setParameter("theId", theId);
        query.executeUpdate();
    }

    @Override
    public List<Book> searchBook(String searchName) {

        // get the hibernate current session
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = null;

        // only search by name if searchName is not null
        if(searchName != null && searchName.trim().length() > 0 ){

            // search for name
            query = currentSession.createQuery("from Book where lower(bookName) like  :searchName", Book.class);
            query.setParameter("searchName", "%" + searchName.toLowerCase() + "%");
        }else {
            query = currentSession.createQuery("from Book", Book.class);
        }
        // execute the query
        List<Book> bookList = query.getResultList();
        return bookList;
    }

    @Override
    public List<Book> getBooksForAuthor(int theId) {

        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createNativeQuery("select BOOK_NAME, BOOK_TYPE   \n" +
                "from book b, author a, book_author ba\n" +
                "where a.AUTHOR_ID = :theId and b.BOOK_ID = ba.BOOK_ID and a.AUTHOR_ID = ba.AUTHOR_ID");
        query.setParameter("theId", theId);

        List<Object> objList = query.list();
        List<Book> bookList= new ArrayList<>(objList.size());
        for(Object obj : objList){
            Object[] objArr = (Object[]) obj;
            Book book = new Book();
            book.setBookName(objArr[0].toString());
            book.setBookType(objArr[1].toString());
            bookList.add(book);
        }

        return bookList;
    }
}
