package ru.simple.opds.scaner.models;

import jakarta.persistence.*;
import ru.simple.opds.scaner.Constants;

@Entity
@Table(name = "genre", indexes = {
        @Index(columnList = "genre", name = "genre_genre"),
        @Index(columnList = "section", name = "genre_section"),
        @Index(columnList = "subsection", name = "genre_subsection")
}
)
public class Genre {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "genre", length = Constants.SIZE_GENRE)
    private String genre;

    @Column(name = "section", length = Constants.SIZE_GENRE_SECTION)
    private String section;

    @Column(name = "subsection", length = Constants.SIZE_GENRE_SUBSECTION)
    private String subsection;

    @Override
    public String toString() {
        return "Genre{" +
                "genre='" + genre + '\'' +
                ", section='" + section + '\'' +
                ", subsection='" + subsection + '\'' +
                '}';
    }
}
