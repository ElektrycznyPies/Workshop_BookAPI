package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;
import pl.coderslab.controller.ErrorControllerAdvice;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {

    private final BookService bookService;

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    // POKAŻ WSZYSTKIE
    @GetMapping("/all")     // w przeglądarce
    public String showAll(Model model) {
        model.addAttribute("books", bookService.getBooks());
        return "/booksAll";  // nazwa pliku
    }

    // DODAWANIE
    @GetMapping(value = "/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "/bookAdd";
    }

    @PostMapping(value = "/add")
    public String saveBook(@Valid Book book, BindingResult result) { // @Valid wymusza proces walidacji określony w modelu book
        if (result.hasErrors()) {
            return "/booksAdd";
        }
        bookService.add(book);
        return "redirect:/admin/books/all";
    }

    // WYŚWIETL 1 detale PO ID
    @GetMapping("/show/{id}")
    public String showBook(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookService.get(id).orElseThrow(EntityNotFoundException::new));
        return "/showOne";
    }

    // KASOWANIE
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/admin/books/all";
    }



}

