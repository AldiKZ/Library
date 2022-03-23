package kz.intexsoft.library.service;

import kz.intexsoft.library.dto.LibraryWithBooksDto;
import kz.intexsoft.library.entity.Library;

import java.util.List;

public interface LibraryService {

    List<Library> readAll();

    Library createLibrary(Library library);

    LibraryWithBooksDto createLibraryWithBooks(LibraryWithBooksDto dto);
}
