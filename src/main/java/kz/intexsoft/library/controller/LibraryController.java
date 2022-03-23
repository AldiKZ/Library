package kz.intexsoft.library.controller;

import kz.intexsoft.library.dto.LibraryDto;
import kz.intexsoft.library.dto.LibraryWithBooksDto;
import kz.intexsoft.library.mapper.LibraryMapper;
import kz.intexsoft.library.service.LibraryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class LibraryController {

    private final LibraryService libraryService;

    private final LibraryMapper libraryMapper;

    public LibraryController(LibraryService libraryService, LibraryMapper libraryMapper) {
        this.libraryService = libraryService;
        this.libraryMapper = libraryMapper;
    }

    @GetMapping("/libraries")
    public ResponseEntity<?> readAllLibraries() {
        return new ResponseEntity<>(libraryService.readAll(), HttpStatus.OK);
    }

    @PostMapping("/library-create")
    public ResponseEntity<String> createLibrary(@RequestBody LibraryDto libraryDto) {
        libraryService.createLibrary(libraryMapper.toEntity(libraryDto));
        return ResponseEntity.ok("Library " + libraryDto.getName() + " successfully added!");
    }

    @PostMapping("/library-books-add")
    public ResponseEntity<LibraryWithBooksDto> addLibraryWithBooks(@RequestBody LibraryWithBooksDto dto) {
        return ResponseEntity.ok(libraryService.createLibraryWithBooks(dto));
    }
}