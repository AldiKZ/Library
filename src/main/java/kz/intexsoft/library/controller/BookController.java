package kz.intexsoft.library.controller;

import kz.intexsoft.library.entity.Book;
import kz.intexsoft.library.service.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping("/books")
    public Book create(@RequestBody Book book) {
        return bookService.create(book);
    }

    @PostMapping("/books")
    public Book update(@RequestBody Book book) {
        return bookService.order(book);
    }
}
