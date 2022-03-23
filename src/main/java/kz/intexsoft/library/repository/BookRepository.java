package kz.intexsoft.library.repository;

import kz.intexsoft.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBookByName(String name);
    List<Book> findBookByAuthor(String author);
}