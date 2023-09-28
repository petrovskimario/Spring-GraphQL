package com.iwlabs.graphql.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class Book {
    @Id
    @SequenceGenerator(name = "book_id_sequence", sequenceName = "book_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_id_sequence")
    private Integer id;

    @Column(name = "name")
    private String name;
}
