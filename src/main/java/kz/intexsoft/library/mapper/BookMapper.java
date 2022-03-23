package kz.intexsoft.library.mapper;

import kz.intexsoft.library.dto.BookDto;
import kz.intexsoft.library.entity.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public Book toEntity(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setAuthor(bookDto.getAuthor());
        book.setName(bookDto.getName());
        return book;
    }

    public List<Book> toEntity(List<BookDto> bookDtoList) {
        return bookDtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public BookDto toDto(Book book) {
        BookDto bookDto = new BookDto();
        return bookDto;
    }
}
