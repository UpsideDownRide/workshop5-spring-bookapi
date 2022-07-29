package pl.upside;

import com.github.javafaker.Faker;
import pl.upside.model.Book;
import pl.upside.repositories.BookRepository;
import pl.upside.repositories.BookRepositoryImpl;

import java.util.Random;
import java.util.stream.LongStream;

public class MockBookRepo extends BookRepositoryImpl {
    BookRepository repository = new BookRepositoryImpl();
    Faker faker = new Faker();
    Random random = new Random();

    public MockBookRepo() {
        LongStream.range(1, 5000)
                .mapToObj(i -> new Book(i, generateISBN(), faker.book().title(),
                        faker.book().author(), faker.book().publisher(), faker.book().genre()))
                .forEach(repository::add);
    }

    public BookRepository getRepository() {
        return repository;
    }

    private String generateISBN() {
        return "0-" + randomDigits(4) + "-" + randomDigits(4) + "-" + randomDigits(1);
    }

    private String randomDigits(int magnitude){
        int bound = (int) Math.pow(10, magnitude - 1);
        return String.format("%04d", random.nextInt(bound) + 1);
    }
}
