package kz.intexsoft.library.mapper;

import kz.intexsoft.library.dto.LibraryDto;
import kz.intexsoft.library.entity.Library;
import org.springframework.stereotype.Component;

@Component
public class LibraryMapper {

    public Library toEntity(LibraryDto dto) {
        Library library = new Library();
        library.setId(dto.getId());
        library.setName(dto.getName());
        return library;
    }

    public LibraryDto toDto(Library library) {
        LibraryDto libraryDto = new LibraryDto();
        libraryDto.setId(library.getId());
        libraryDto.setName(library.getName());
        return libraryDto;
    }
}
