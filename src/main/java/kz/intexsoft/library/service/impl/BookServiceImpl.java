package kz.intexsoft.library.service.impl;

import kz.intexsoft.library.entity.Book;
import kz.intexsoft.library.repository.BookRepository;
import kz.intexsoft.library.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
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
