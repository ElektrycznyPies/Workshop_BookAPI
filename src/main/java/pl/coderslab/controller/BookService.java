package pl.coderslab.controller;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;
import java.util.List;
import java.util.Optional;

@Service
public interface BookService {
    List<Book> getBooks();

    Optional<Book> get(Long id);

    void add(Book book);

    void delete(Long id);

    void update(Book book);
}

