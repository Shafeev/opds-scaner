package mcs.opds.scan.models;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Author")
public class Author {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "search_full_name")
    private String search_full_name;

    @Column(name = "lang_code")
    private int langCode;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    @Override
    public String toString() {
        return "Author{" +
                "full_name='" + full_name + '\'' +
                ", search_full_name='" + search_full_name + '\'' +
                ", langCode=" + langCode +
                '}';
    }
}
