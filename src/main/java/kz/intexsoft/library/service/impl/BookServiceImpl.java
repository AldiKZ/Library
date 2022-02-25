package kz.intexsoft.library.service.impl;

import kz.intexsoft.library.entity.Book;
import kz.intexsoft.library.repository.BookRepository;
import kz.intexsoft.library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    private static final Map<Long, Book> BOOK_REPOSITORY_MAP = new HashMap<>();
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> find() {
        return new ArrayList<>();
    }

    @Override
    public Book order(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public Book reset(Book book) {
        return null;
    }
}
