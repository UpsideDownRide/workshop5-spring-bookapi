package pl.upside.repositories;

import pl.upside.model.Book;

import java.util.Optional;

public interface BookRepository {
    void add(Book book);
    void remove(Book book);
    Optional<Book> get(Long id);
    Iterable<Book> getAll();
}
