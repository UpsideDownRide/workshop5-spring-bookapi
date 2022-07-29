package pl.upside.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public final class BookWithoutId implements IBook {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String genre;
}
