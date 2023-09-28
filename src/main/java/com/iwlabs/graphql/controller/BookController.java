package com.iwlabs.graphql.controller;

import com.iwlabs.graphql.model.Book;
import com.iwlabs.graphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @QueryMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @QueryMapping
    public Book getById(@Argument Integer id) {
        return bookService.findById(id);
    }

    @MutationMapping
    public Book createBook(@Argument String name) {
        return bookService.createBook(name);
    }

    @MutationMapping
    public Book updateBook(@Argument Integer id, @Argument String name) {
        return bookService.updateBook(id, name);
    }

    @MutationMapping
    public String deleteBook(@Argument Integer id) {
        return bookService.deleteBook(id);
    }
}
