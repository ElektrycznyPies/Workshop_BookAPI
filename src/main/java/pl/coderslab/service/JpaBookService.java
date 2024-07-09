package pl.coderslab.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;
import pl.coderslab.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JpaBookService implements BookService {

    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
    @Override
    public Optional<Book> get(Long id) {
        return Optional.empty();
    }
    @Override
    public void add(Book book) {
    }
    @Override
    public void delete(Long id) {
    }
    @Override
    public void update(Book book) {
    }

}
