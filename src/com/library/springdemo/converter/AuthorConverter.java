package com.library.springdemo.converter;

import com.library.springdemo.entity.Author;
import com.library.springdemo.service.AuthorService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibrahimg on 13.11.2018.
 */

public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    AuthorService authorService;


    @Override
    public Author convert(String source) {
        Author author = authorService.getAuthors(Integer.valueOf(source));
        return author;
    }
}
