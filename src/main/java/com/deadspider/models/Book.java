package com.deadspider.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_books")
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private String genre;
    private String publisher;
    private String pages;

    public Book initBooksCSV(String[] s)  {
        this.title = s[0];
        this.author = s[1];
        this.genre = s[2];
        this.pages = s[3];
        this.publisher = s[3];
        return this;
    }

}
