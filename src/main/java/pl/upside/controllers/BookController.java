package pl.upside.controllers;

import org.springframework.web.bind.annotation.*;
import pl.upside.MockBookRepo;
import pl.upside.model.Book;
import pl.upside.model.BookToAdd;
import pl.upside.model.BookToUpdate;
import pl.upside.repositories.BookRepository;


@RestController
@RequestMapping("/books")
public class BookController {
    BookRepository repository;

    BookController() {
        this.repository = new MockBookRepo().getRepository();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return repository.get(id).orElseThrow(BookNotFoundException::new);
    }

    @GetMapping("")
    public Iterable<Book> getAllBooks() {
        return repository.getAll();
    }

    @PostMapping("")
    public Book addBook(@RequestBody BookToAdd bookToAdd) {
        Long id = repository.size() + 1;
        Book bookWithId = new Book(id, bookToAdd.isbn(), bookToAdd.title(), bookToAdd.author(),
                bookToAdd.publisher(), bookToAdd.genre());
        repository.add(bookWithId);
        return bookWithId;
    }

    @PutMapping("")
    public Book updateBook(@RequestBody BookToUpdate bookToUpdate) {
        return repository.update(bookToUpdate);
    }

    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable Long id) {
        repository.remove(id);
    }
}

