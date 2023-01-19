package mcs.opds.scan.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "filename")
    private String filename;

    @Column(name = "path")
    private String path;

    @Column(name = "filesize")
    private int filesize;

    @Column(name = "format")
    private String format;

    @Column(name = "cat_type")
    private int catType;

    @Column(name = "registerdate")
    private Date registerDate;

    @Column(name = "docdate")
    private String docdate;

    @Column(name = "lang")
    private String lang;

    @Column(name = "title")
    private String title;

    @Column(name = "search_title")
    private String searchTitle;

    @Column(name = "annotation")
    private String annotation;

    @Column(name = "lang_code")
    private int langCode;

    @Column(name = "avail")
    private int avail;

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
