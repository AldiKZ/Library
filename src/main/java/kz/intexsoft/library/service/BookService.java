package kz.intexsoft.library.service;

import kz.intexsoft.library.entity.Book;

public interface BookService {

    Book create(Book book);

    Book order(Book book);

    Book reset(Book book);
}
