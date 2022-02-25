package kz.intexsoft.library.service;

import kz.intexsoft.library.entity.Book;

import java.util.List;

public interface BookService {

    Book create(Book book);

    List<Book> find();

    Book order(Book book);

    Book reset(Book book);
}
