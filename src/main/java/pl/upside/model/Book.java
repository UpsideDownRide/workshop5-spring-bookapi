package pl.upside.model;

public record Book(long id, String isbn, String title, String author, String publisher,
                   String genre) {
}
