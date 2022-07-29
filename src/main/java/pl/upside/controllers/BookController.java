package pl.upside.controllers;

import org.springframework.web.bind.annotation.*;
import pl.upside.MockBookRepo;
import pl.upside.model.Book;
import pl.upside.model.BookWithoutId;
import pl.upside.repositories.BookRepository;


@RestController
@RequestMapping("/books")
public class BookController {
    BookRepository repository;

    BookController(BookRepository bookRepository) {
        this.repository = bookRepository;
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Book getBook(@PathVariable Long id) {
        return repository.get(id).orElseThrow(BookNotFoundException::new);
    }

    @GetMapping(value = "")
    public Iterable<Book> getAllBooks() {
        return repository.getAll();
    }

    @PostMapping(value = "")
    public Book addBook(@RequestBody BookWithoutId bookWithoutId) {
        return repository.add(bookWithoutId);
    }

    @PutMapping(value = "")
    public Book updateBook(@RequestBody Book bookToUpdate) {
        return repository.update(bookToUpdate);
    }

    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable Long id) {
        repository.remove(id);
    }
}

