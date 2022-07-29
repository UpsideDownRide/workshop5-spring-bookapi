package pl.upside.repositories;

import pl.upside.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository {
    private final Map<Long, Book> books = new HashMap<>();

    @Override
    public void add(Book book) {
        books.put(book.id(), book);
    }

    @Override
    public void remove(Book book) {
        books.remove(book.id(), book);
    }

    @Override
    public Optional<Book> get(Long id) {
        return Optional.ofNullable(books.get(id));
    }

    @Override
    public Iterable<Book> getAll() {
        return new ArrayList<>(books.values());
    }
}
