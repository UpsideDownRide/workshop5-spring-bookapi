package pl.upside.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.upside.MockBookRepo;
import pl.upside.model.Book;
import pl.upside.repositories.BookRepository;


@RestController
@RequestMapping("/books")
public class BookController {
    BookRepository repository;

    BookController() {
        this.repository = new MockBookRepo().getRepository();
    }

    @GetMapping("/hello")
    public Book hello() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return repository.get(id).orElseThrow(BookNotFoundException::new);
    }
}
