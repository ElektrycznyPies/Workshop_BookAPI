package pl.coderslab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;
import pl.coderslab.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JpaBookService implements BookService {

    @Autowired
    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {  // wstrzyknięcie zal.
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> get(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }
}
