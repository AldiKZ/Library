package kz.intexsoft.library.service.impl;

import kz.intexsoft.library.dto.BookDto;
import kz.intexsoft.library.dto.LibraryWithBooksDto;
import kz.intexsoft.library.entity.Book;
import kz.intexsoft.library.entity.Library;
import kz.intexsoft.library.mapper.BookMapper;
import kz.intexsoft.library.mapper.LibraryMapper;
import kz.intexsoft.library.repository.BookRepository;
import kz.intexsoft.library.repository.LibraryRepository;
import kz.intexsoft.library.service.LibraryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryServiceImpl implements LibraryService {

    private final LibraryRepository libraryRepository;
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final LibraryMapper libraryMapper;

    public LibraryServiceImpl(LibraryRepository libraryRepository,
                              LibraryMapper libraryMapper,
                              BookRepository bookRepository,
                              BookMapper bookMapper,
                              LibraryMapper libraryMapper1) {
        this.libraryRepository = libraryRepository;
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.libraryMapper = libraryMapper1;
    }

    @Override
    public List<Library> readAll() {
        List<Library> libraries = libraryRepository.findAll();
        return libraries;
    }

    @Override
    public Library createLibrary(Library library) {
        libraryRepository.save(library);
        return library;
    }

    @Override
    @Transactional
    public LibraryWithBooksDto createLibraryWithBooks(LibraryWithBooksDto dto) {
        Library library = libraryMapper.toEntity(dto.getLibrary());
        libraryRepository.save(library);
        List<Book> books = bookMapper.toEntity(dto.getBooks());
        books.forEach(book -> book.setLibrary(library));
        bookRepository.saveAll(books);
        return dto;
    }
}
