package kz.intexsoft.library.service.impl;

import kz.intexsoft.library.entity.Library;
import kz.intexsoft.library.repository.LibraryRepository;
import kz.intexsoft.library.service.LibraryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService{

    private final LibraryRepository libraryRepository;

    public LibraryServiceImpl(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Override
    public List<Library> readAll() {
        List<Library> libraries = libraryRepository.findAll();
        return  libraries;
    }
}
