package com.iwlabs.graphql.service;

import com.iwlabs.graphql.model.Author;
import com.iwlabs.graphql.model.Book;

import java.util.List;
import java.util.Map;

public interface BookService {
    List<Book> findAll();

    Book createBook(String name,List<String> authorNames);

    Book findById(Integer id);

    Book updateBook(Integer id, String name);

    String deleteBook(Integer id);

    String findByName(String name);

    Map<Book, List<Author>> findAuthorsForBooks(List<Book> books);
}
