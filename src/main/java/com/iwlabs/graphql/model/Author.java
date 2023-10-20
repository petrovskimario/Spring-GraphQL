package com.iwlabs.graphql.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "authors")
@Data
public class Author {
    @Id
    @SequenceGenerator(name = "author_id_sequence", sequenceName = "author_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "author_id_sequence")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private Book book;
}
