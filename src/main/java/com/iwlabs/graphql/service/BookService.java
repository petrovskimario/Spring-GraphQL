package com.iwlabs.graphql.service;

import com.iwlabs.graphql.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book createBook(String name);

    Book findById(Integer id);

    Book updateBook(Integer id, String name);

    String deleteBook(Integer id);
}
