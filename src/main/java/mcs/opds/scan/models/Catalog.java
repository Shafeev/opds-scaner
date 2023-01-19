package mcs.opds.scan.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Catalog")
public class Catalog {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cat_name")
    private String catName;

    @Column(name = "path")
    private String path;

    @Column(name = "cat_type")
    private int catType;

    @Column(name = "cat_size")
    private int catSize;

    @Override
    public String toString() {
        return "Catalog{" +
                "catName='" + catName + '\'' +
                ", path='" + path + '\'' +
                ", catType=" + catType +
                ", catSize=" + catSize +
                '}';
    }
}
