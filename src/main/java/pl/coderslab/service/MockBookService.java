package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MockBookService implements BookService {

    private static Long nextId = 4L;
    private List<Book> books;

    public MockBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz głową - Java", "Sierra Kathy, Bates Bert", "Helion", "programming"));
        books.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Optional<Book> get(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    @Override
    public void add(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    @Override
    public void delete(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    @Override
    public void update(Book book) {
        books.stream().filter(b -> b.getId().equals(book.getId())).findFirst().ifPresent(existingBook -> {
            existingBook.setIsbn(book.getIsbn());
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setPublisher(book.getPublisher());
            existingBook.setType(book.getType());
        });
    }
}
