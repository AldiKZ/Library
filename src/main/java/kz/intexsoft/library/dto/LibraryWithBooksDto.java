package kz.intexsoft.library.dto;

import java.util.ArrayList;
import java.util.List;

public class LibraryWithBooksDto {

    private LibraryDto library;

    private List<BookDto> books = new ArrayList<>();

    public LibraryDto getLibrary() {
        return library;
    }

    public void setLibrary(LibraryDto library) {
        this.library = library;
    }

    public List<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> books) {
        this.books = books;
    }
}
