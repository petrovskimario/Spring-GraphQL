package com.iwlabs.graphql.service.impl;

import com.iwlabs.graphql.infrstructure.exception.ResourceNotFoundException;
import com.iwlabs.graphql.model.Author;
import com.iwlabs.graphql.model.Book;
import com.iwlabs.graphql.repository.AuthorRepository;
import com.iwlabs.graphql.repository.BookRepository;
import com.iwlabs.graphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Book createBook(String name) {
        Book book = new Book();
        book.setName(name);
        return repository.save(book);
    }

    @Override
    public Book findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    }

    @Override
    public Book updateBook(Integer id, String name) {
        Book book = findById(id);
        book.setName(name);
        return repository.save(book);
    }

    @Override
    public String deleteBook(Integer id) {
        Book book = findById(id);
        repository.delete(book);
        return "Deleted";
    }

    @Override
    public String findByName(String name) {
        Book byName = repository.findByName(name);
        return byName.getName();
    }

    @Override
    public Map<Book, List<Author>> findAuthorsForBooks(List<Book> books) {
        List<Author> authors = authorRepository.findByBookIn(books);
        Map<Book, List<Author>> bookToAuthorsMap = new HashMap<>();

        for (Book book : books) {
            List<Author> bookAuthors = authors.stream()
                    .filter(author -> author.getBook().equals(book))
                    .collect(Collectors.toList());
            bookToAuthorsMap.put(book, bookAuthors);
        }

        return bookToAuthorsMap;
    }
}
