package com.iwlabs.graphql.controller;

import com.iwlabs.graphql.model.Author;
import com.iwlabs.graphql.model.Book;
import com.iwlabs.graphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

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

    @QueryMapping
    public String getByName(@Argument String name) {
        return bookService.findByName(name);
    }

    @MutationMapping
    public Book createBook(@Argument String name,@Argument List<String> authorNames) {
        return bookService.createBook(name,authorNames);
    }

    @MutationMapping
    public Book updateBook(@Argument Integer id, @Argument String name) {
        return bookService.updateBook(id, name);
    }

    @MutationMapping
    public String deleteBook(@Argument Integer id) {
        return bookService.deleteBook(id);
    }

    @BatchMapping(field = "authors", typeName = "Book")
    public Map<Book,List<Author>> authors(List<Book> books) {
        return bookService.findAuthorsForBooks(books);
    }
}
