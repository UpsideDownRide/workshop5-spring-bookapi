package pl.upside.repositories;

import pl.upside.model.Book;
import pl.upside.model.BookToUpdate;

import java.util.Optional;

public interface BookRepository {
    void add(Book book);
    void remove(Long id);
    Book update(BookToUpdate bookToUpdate);
    Optional<Book> get(Long id);
    Iterable<Book> getAll();
    Long size();
}
