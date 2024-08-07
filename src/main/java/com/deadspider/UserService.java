package com.deadspider;

import com.deadspider.models.Book;
import com.deadspider.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Service
public class UserService {

    private BookRepo repo;
    public final Supplier<List<Book>> all;
    public final Function<Book, Predicate<String>> checkAuthor =
                (book)-> (author) -> book.getAuthor().equalsIgnoreCase(author);
    public final Function<String, Optional<Book>> byAuthor;

    public UserService(BookRepo repo) {
        this.repo = repo;
        all = repo::findAll;
        byAuthor = author -> all.get().stream().filter(s->checkAuthor.apply(s).test(author)).findFirst();
    }
}
