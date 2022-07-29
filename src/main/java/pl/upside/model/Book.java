package pl.upside.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Book implements IBook {
    @JsonProperty(required = true)
    Long   id;
    String isbn;
    String title;
    String author;
    String publisher;
    String genre;

    public Book(Long id, BookWithoutId bookWithoutId) {
        this.id = id;
        this.author = bookWithoutId.getAuthor();
        this.title = bookWithoutId.getTitle();
        this.isbn = bookWithoutId.getIsbn();
        this.publisher = bookWithoutId.getPublisher();
        this.genre = bookWithoutId.getGenre();
    }
}
