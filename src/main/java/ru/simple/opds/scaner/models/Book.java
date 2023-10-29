package ru.simple.opds.scaner.models;

import jakarta.persistence.*;
import ru.simple.opds.scaner.Constants;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book", indexes = {
        @Index(columnList = "filename", name = "book_filename"),
        @Index(columnList = "path", name = "book_path"),
        @Index(columnList = "cat_type ", name = "book_cat_type"),
        @Index(columnList = "docdate", name = "book_docdate"),
        @Index(columnList = "title", name = "book_title"),
        @Index(columnList = "search_title", name = "book_search_title"),
        @Index(columnList = "lang_code", name = "book_lang_code"),
        @Index(columnList = "avail", name = "book_avail")
})
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "filename", length = Constants.SIZE_BOOK_FILENAME)
    private String filename;

    @Column(name = "path", length = Constants.SIZE_BOOK_PATH)
    private String path;

    @Column(name = "filesize", nullable = false)
    private int filesize;

    @Column(name = "format", length = Constants.SIZE_BOOK_FORMAT)
    private String format;

    @Column(name = "cat_type", nullable = false)
    private int catType;

    @Column(name = "registerdate", nullable = false)
    private Date registerDate;

    @Column(name = "docdate", length = Constants.SIZE_BOOK_DOCDATE)
    private String docdate;

    @Column(name = "lang", length = Constants.SIZE_BOOK_LANG)
    private String lang;

    @Column(name = "lang_code", columnDefinition = "int default 9")
    private int langCode;

    @Column(name = "title", length = Constants.SIZE_BOOK_TITLE)
    private String title;

    @Column(name = "search_title", length = Constants.SIZE_BOOK_TITLE)
    private String searchTitle;

    @Column(name = "annotation", length = Constants.SIZE_BOOK_ANNOTATION)
    private String annotation;

    @Column(name = "avail", nullable = false)
    private int avail;

    @ManyToMany
    @JoinTable(
            name = "bauthor",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")},
            uniqueConstraints = @UniqueConstraint(name="index_together", columnNames = {"book_id", "author_id"})
    )
    Set<Author> authors = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "bgenre",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id")}
    )
    Set<Genre> genres = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "bseries",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "series_id")},
            indexes = @Index(columnList = "book_id,series_id", name = "index_together"),
            uniqueConstraints = @UniqueConstraint(name="index_together", columnNames = {"book_id", "series_id"})
    )
    Set<Series> series = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinTable(name = "catalog", joinColumns = @JoinColumn(name = "id_book"), inverseJoinColumns = @JoinColumn(name = "id_catalog"))
    private Catalog catalog;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", path='" + path + '\'' +
                ", filesize=" + filesize +
                ", format='" + format + '\'' +
                ", catType=" + catType +
                ", registerDate=" + registerDate +
                ", docdate='" + docdate + '\'' +
                ", lang='" + lang + '\'' +
                ", title='" + title + '\'' +
                ", searchTitle='" + searchTitle + '\'' +
                ", annotation='" + annotation + '\'' +
                ", langCode=" + langCode +
                ", avail=" + avail +
                '}';
    }
}
