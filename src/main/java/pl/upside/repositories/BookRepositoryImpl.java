package pl.upside.repositories;

import pl.upside.controllers.BookNotFoundException;
import pl.upside.model.Book;
import pl.upside.model.BookToUpdate;
import pl.upside.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BookRepositoryImpl implements BookRepository {
    private final Map<Long, Book> books = new HashMap<>();

    @Override
    public void add(Book book) {
        books.put(book.getId(), book);
    }

    @Override
    public void remove(Long id) {
        Book book = get(id).orElseThrow(BookNotFoundException::new);
        books.remove(book.getId(), book);
    }

    @Override
    public Optional<Book> get(Long id) {
        return Optional.ofNullable(books.get(id));
    }

    @Override
    public Iterable<Book> getAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Book update(BookToUpdate bookToUpdate) {
        Book originalBook = get(bookToUpdate.getId()).orElseThrow(BookNotFoundException::new);
        Utils.copyNonNullProperties(bookToUpdate, originalBook);
        return originalBook;
    }

    @Override
    public Long size() {
        return (long) books.size();
    }
}
