package com.library.springdemo.controller;

import com.library.springdemo.entity.Author;
import com.library.springdemo.entity.Book;
import com.library.springdemo.service.AuthorService;
import com.library.springdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by ibrahimg on 08.11.2018.
 */
@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public String listAuthor(Model theModel) {

	
	
        List<Author> authorList = authorService.getAuthors();
        theModel.addAttribute("authors", authorList);
        return "author-list";
    }

    @GetMapping("/showFormForAddAuthor")
    public String showFormForAddAuthor(Model theModel) {

        Author theAuthor = new Author();
        theModel.addAttribute("author", theAuthor);
        return "author-form";
    }

    @PostMapping("/saveAuthor")
//    @ExceptionHandler({SpringException.class})
    public String saveAuthor(@ModelAttribute("author") @Valid Author theAuthor, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "author-form";
        }
        authorService.saveAuthor(theAuthor);
        return "redirect:/author/list";
    }

    @GetMapping("/showFormForAuthorUpdate")
    public String showFormForAuthorUpdate(@RequestParam("authorId") int theId, Model theModel) {

        Author author = authorService.getAuthors(theId);
        theModel.addAttribute(author);
        return "author-form";
    }

    @GetMapping("/showFormForAuthorDelete")
    public String showFormForAuthorDelete(@RequestParam("authorId") int theId, Model theModel) {

        authorService.deleteAuthor(theId);
        return "redirect:/author/list";
    }

    @GetMapping("/searchAuthor")
    public String searchAuthor(@RequestParam("searchNameAndLastName") String searchNameAndSurname, Model theModel) {

        List<Author> theAuthors = authorService.searchAuthor(searchNameAndSurname);

        theModel.addAttribute("authors", theAuthors);

        return "author-list";
    }

    @GetMapping("/showBooksAuthor")
    public String showBooksAuthor(@RequestParam("authorId") int theId, Model theModel) {

        List<Book> bookList = bookService.getBooksForAuthor(theId);

        theModel.addAttribute("books", bookList);

        return "book-list";
    }
}
