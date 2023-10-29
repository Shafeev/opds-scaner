package ru.simple.opds.scaner.models;

import jakarta.persistence.*;
import ru.simple.opds.scaner.Constants;

@Entity
@Table(name = "series",
        indexes = {
            @Index(columnList = "ser", name = "series_ser"),
            @Index(columnList = "search_ser", name = "series_search_ser"),
            @Index(columnList = "lang_code", name = "series_lang_code")
        })
public class Series {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ser", length = Constants.SIZE_SERIES)
    private String ser;

    @Column(name = "search_ser", length = Constants.SIZE_SERIES)
    private String searchSer;

    @Column(name = "lang_code",  columnDefinition = "int default 9")
    private String langCode;
}
