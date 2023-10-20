package com.iwlabs.graphql.repository;

import com.iwlabs.graphql.model.Author;
import com.iwlabs.graphql.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
    List<Author> findByBookIn(List<Book> books);
}
