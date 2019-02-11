package com.library.springdemo.controller;

import com.library.springdemo.entity.Author;
import com.library.springdemo.entity.Book;
import com.library.springdemo.service.AuthorService;
import com.library.springdemo.service.BookService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by ibrahimg on 02.11.2018.
 */
@Controller
@RequestMapping("/book")
public class BookController implements InitializingBean{

    // need to inject the book service
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/list")
    public String listBooks(Model theModel) {

        List<Book> bookList = bookService.getBooks();

        theModel.addAttribute("books", bookList);

        return "book-list";
    }

    @GetMapping("/showFormForAddBooks")
    public String showFormForAddBooks(Model theModel) {

        Book book = new Book();
        List<Author> authorList = authorService.getAuthors();
        theModel.addAttribute("book", book);
        theModel.addAttribute("authors", authorList);
        return "book-form";
    }

    @PostMapping("/saveBook")
    public String saveBook(Book theBook, BindingResult result, ModelMap model) {

        bookService.saveBook(theBook);
        return "redirect:/book/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookId") int theId, Model theModel) {

        Book theBook = bookService.getBooks(theId);
        theModel.addAttribute("book", theBook);

        List<Author> authorList = authorService.getAuthors();
        theBook.setAuthors(authorList);
        theModel.addAttribute("authors", authorList);
        return "book-form";
    }

    @GetMapping("showFormForDelete")
    public String showFormForDelete(@RequestParam("bookId") int theId, Model theModel) {

        bookService.deleteBook(theId);
        return "redirect:/book/list";
    }

    @GetMapping("searchBook")
    public String searchBook(@RequestParam("searchName") String searchName, Model theModel) {

        List<Book> bookList = bookService.searchBook(searchName);
        theModel.addAttribute("books", bookList);
        return "book-list";
    }

    @GetMapping("/showAuthorForBook")
    public String showAuthorForBook(@RequestParam("bookId") int theId, Model theModel){

        List<Author> authorList = authorService.getAuthorsForBook(theId);
        theModel.addAttribute("authors", authorList);
        return "author-list";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Inıt");
    }
}
