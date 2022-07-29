package pl.upside.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public final class BookToUpdate {
    @JsonProperty(required = true)
    Long id;
    String isbn;
    String title;
    String author;
    String publisher;
    String genre;

    public BookToUpdate(@JsonProperty(required = true) Long id, String isbn, String title, String author, String publisher, String genre) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
    }

    public BookToUpdate() {
    }

}
