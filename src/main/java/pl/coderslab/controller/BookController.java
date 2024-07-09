package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;

import java.util.List;
import java.util.Optional;

@RestController // równoznaczna z ResponseBody
@RequestMapping("/books")
public class BookController {

    // wstrzyknięcie zależności
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // WYŚWIETL WSZYSTKIE

//    // LISTA Z UŻYCIEM RESPONSEENTITY, POZWALA ZOBACZYĆ ODP. SERWERA 200 OK
//    @RequestMapping("")
//    @ResponseBody
//    public ResponseEntity<List<Book>> getList() {
//        List<Book> books = bookService.getBooks();
//        return ResponseEntity.ok(books);
//    }

    // KLASYCZNA LISTA
        @RequestMapping("")
        @ResponseBody
        public List<Book> getList() {
            List<Book> books = bookService.getBooks();
            return books;
        }

    // WYŚWIETL 1 WEDŁUG ID
//    @RequestMapping("/{id}")
//    public ResponseEntity<Book> get(@PathVariable Long id) {
//        Optional<Book> bookOptional = bookService.get(id);
//
//        if (bookOptional.isPresent()) {
//            Book book = bookOptional.get();
//            return ResponseEntity.ok(book); // zwraca książkę ze statusem 200 OK
//        } else {
//            return ResponseEntity.notFound().build(); // zwraca status 404 Not Found
//        }
//    }


    // WYŚWIETL 1 WEDŁUG ID
    @RequestMapping("/{id}")
    public Optional<Book> get(@PathVariable Long id) {
        Optional<Book> bookOptional = bookService.get(id);
        return bookOptional;
    }

    // DODAJ KSIĄŻKĘ (CURLEM W JSON-ie)
    @PostMapping("")
    public void addBook(@RequestBody Book book) { // @RB potrzebne, by przerobić json na obiekt. Dodajemy json curlem
        bookService.add(book);
    }
    //SKŁADNIA DLA CURLA:
    // curl -X POST -i -H "Content-Type: application/json" -d '{"isbn":"34321","title":"Thinking in Java", "publisher":"Helion","type":"programming", "author":"Bruce Eckel"}' http://localhost:8080/books

    // USUŃ KSIĄŻKĘ WG ID
    @RequestMapping("/del/{id}")
    public Optional<Book> delete(@PathVariable Long id) {
        Optional<Book> bookOptional = bookService.get(id);

        if (bookOptional.isPresent()) {
            bookService.delete(id);
            return bookOptional;
        } else {
            return Optional.empty();
        }
    }

    // ZMODYFIKUJ KSIĄŻKĘ WG CURLA
    @PutMapping("")
    @ResponseBody
    public void updateBook(@RequestBody Book book) {
        bookService.update(book);
    }
    // SKŁADNIA DLA CURLA:
    // curl -X PUT -i -H "Content-Type: application/json" -d '{"id":2,"isbn":"666666","title":"Thinking in C#", "publisher":"IT Books","type":"programming", "author":"Bruce Eckel"}' http://localhost:8080/books


    // TEST TOMCATA
    @RequestMapping("/hello")
    @ResponseBody
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }
}
