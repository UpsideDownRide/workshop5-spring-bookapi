package pl.upside.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Book {
    Long   id;
    String isbn;
    String title;
    String author;
    String publisher;
    String genre;
}
