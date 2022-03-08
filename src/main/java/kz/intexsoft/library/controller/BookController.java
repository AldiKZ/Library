package kz.intexsoft.library.controller;

import kz.intexsoft.library.entity.Book;
import kz.intexsoft.library.exception.BookNotFoundException;
import kz.intexsoft.library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping("/book-add")
    public ResponseEntity<String> create(@RequestBody Book book) {
        bookService.create(book);
        return ResponseEntity.ok("Book '"+book.getName()+"' successfully added!");
    }

    @GetMapping("/books-author")
    public ResponseEntity<?> findBookByAuthor(@RequestParam String author) throws BookNotFoundException {
        return ResponseEntity.ok(bookService.findBookByAuthor(author));
    }

    @GetMapping("/books-name")
    public ResponseEntity<?> findBookByName(@RequestParam String name) throws BookNotFoundException {
        return ResponseEntity.ok(bookService.findBookByName(name));
    }

    @GetMapping(value = "/book-order/{id}")
    public ResponseEntity<String> orderBook(@PathVariable Long id) {
        return new ResponseEntity<String>(bookService.order(id), HttpStatus.OK);
    }

    @GetMapping(value = "book-reset/{id}")
    public ResponseEntity<String> resetBook(@PathVariable Long id) {
        return new ResponseEntity<String>(bookService.reset(id), HttpStatus.OK);
    }
}
