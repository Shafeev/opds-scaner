package mcs.opds.scan.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Genre")
public class Genre {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "genre")
    private String genre;

    @Column(name = "section")
    private String section;

    @Column(name = "subsection")
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
