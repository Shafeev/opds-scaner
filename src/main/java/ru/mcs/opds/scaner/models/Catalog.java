package ru.mcs.opds.scaner.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "catalog")
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

    @ManyToOne()
    private Catalog parentCatalog;

    @OneToMany(mappedBy = "parentCatalog")
    private Set<Catalog> subCatalogs = new HashSet<>();

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
