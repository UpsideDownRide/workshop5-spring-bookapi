package pl.upside.repositories;

import pl.upside.model.Book;
import pl.upside.model.BookWithoutId;

import java.util.Optional;

public interface BookRepository {
    Book add(Book book);
    Book add(BookWithoutId bookWithoutId);
    void remove(Long id);
    Book update(Book bookToUpdate);
    Optional<Book> get(Long id);
    Iterable<Book> getAll();
    Long size();
}
