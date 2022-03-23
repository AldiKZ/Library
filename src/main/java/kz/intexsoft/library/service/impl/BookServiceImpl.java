package kz.intexsoft.library.service.impl;

import kz.intexsoft.library.entity.Book;
import kz.intexsoft.library.exception.BookNotFoundException;
import kz.intexsoft.library.repository.BookRepository;
import kz.intexsoft.library.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    public List<Book> findBookByName(String name) throws BookNotFoundException {
        List<Book> books = bookRepository.findBookByName(name);
        if (books == null) {
            throw new BookNotFoundException("Книга не найдена");
        }
        return books;
    }

    @Override
    public List<Book> findBookByAuthor(String author) throws BookNotFoundException {
        List<Book> books = bookRepository.findBookByAuthor(author);
        if (books.isEmpty()) {
            throw new BookNotFoundException("Книга не найдена");
        }
        return books;
    }

    @Override
    @Transactional
    public String order(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            if (book.getOrderDate() == null) {
                book.setOrderDate(LocalDate.now());
                bookRepository.save(book);
                return "Успешно забронирована!";
            } else {
                return "Книга занята!";
            }
        }
        return "Нет такой книги";
    }

    @Override
    public String reset(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            if (book.getOrderDate() == null){
                return "Книга уже свободна";
            }
            else {
                book.setOrderDate(null);
                bookRepository.save(book);
                return "Книга успешно возвращена";
            }
        }
        return "Вы ввели неправильные данные";
    }


}
