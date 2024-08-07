package com.deadspider;


import com.deadspider.models.Book;
import com.deadspider.repos.BookRepo;
import com.deadspider.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.io.File;
import java.util.List;

@SpringBootApplication
public class SpringApplicationRunner {

    @Autowired
    private BookRepo repo;

    private void initBookTable() {
        try {
            List<Book> books = Utilities.readAllLines(new File("src/main/resources/books.csv").toPath())
                    .stream().map(s->new Book().initBooksCSV(s)).toList();
            books = repo.saveAllAndFlush(books);
            System.out.println("PERSISTED: " + books.size());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringApplicationRunner.class, args);
       // ctx.getBean(SpringApplicationRunner.class).initBookTable();

    }
}
