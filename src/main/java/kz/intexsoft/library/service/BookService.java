package kz.intexsoft.library.service;

import kz.intexsoft.library.entity.Book;
import kz.intexsoft.library.exception.BookNotFoundException;

import java.util.List;

public interface BookService {

    Book create(Book book);

    List<Book> findBookByName(String name) throws BookNotFoundException;

    List<Book> findBookByAuthor(String author) throws BookNotFoundException;

    String order(Long id);

    String reset(Long id);
}
