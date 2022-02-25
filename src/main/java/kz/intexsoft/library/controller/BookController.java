package kz.intexsoft.library.controller;

import kz.intexsoft.library.entity.Book;
import kz.intexsoft.library.service.BookService;
import kz.intexsoft.library.service.impl.BookServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/books")
    public List<Book> find(){
        return null;
    }

    @PutMapping("/order-book")
    public Book order(@RequestBody Book book) {
        return bookService.order(book);
    }

}
