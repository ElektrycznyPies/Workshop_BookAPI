package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;

import javax.persistence.EntityNotFoundException;
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

    // WYŚWIETL detale jednej PO ID

    @GetMapping("/show/{id}")
    public String showBook(Model model, @PathVariable Long id) {
        //stworzenie obiektu, ponieważ met. get() z BookController daje Optional, a nie obiekt. Optional utrudnia pracę z jsp
        Book book = bookService.get(id).orElseThrow(() -> new EntityNotFoundException("Book " + id + " not found"));
        model.addAttribute("book", book);
        return "/showOne";
    }

    // EDYCJA
    @GetMapping(value = "/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.get(id));
        return "/bookEdit";
    }

    @PostMapping(value = "/edit")
    public String editBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/bookEdit";
        }
        bookService.add(book);
        return "redirect:/admin/books/all";
    }


    // KASOWANIE
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/admin/books/all";
    }
}

//package pl.coderslab.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import pl.coderslab.model.Book;
//import pl.coderslab.service.BookService;
//import javax.validation.Valid;
//
//@Controller
//@RequestMapping("/admin/books")
//public class ManageBookController {
//
//    private final BookService bookService;
//
//    public ManageBookController(BookService bookService) {
//        this.bookService = bookService;
//    }
//
//    // POKAŻ WSZYSTKIE
//    @GetMapping("/all")     // w przeglądarce
//    public String showAll(Model model) {
//        model.addAttribute("books", bookService.getBooks());
//        return "/booksAll";  // nazwa pliku
//    }
//
//    // DODAWANIE
//    @GetMapping(value = "/add")
//    public String showAddForm(Model model) {
//        model.addAttribute("book", new Book());
//        return "/bookAdd";
//    }
//
//    @PostMapping(value = "/add")
//    public String saveBook(@Valid Book book, BindingResult result) { // @Valid wymusza proces walidacji określony w modelu book
//        if (result.hasErrors()) {
//            return "/bookAdd";
//        }
//        bookService.add(book);
//        return "redirect:/admin/books/all";
//    }
//
////    // WYŚWIETL 1 detale PO ID
////    @GetMapping("/show/{id}")
////    public String showBook(Model model, @PathVariable Long id) {
////        model.addAttribute("book", bookService.get(id));
////        return "/showOne";
////    }
//
////    // KASOWANIE
////    @GetMapping("/delete/{id}")
////    public String deleteBook(@PathVariable Long id) {
////        bookService.delete(id);
////        return "redirect:/admin/books/all";
////    }
//}
//
