package ru.simple.opds.scaner.models;

import jakarta.persistence.*;
import ru.simple.opds.scaner.Constants;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "catalog", indexes = {
        @Index(columnList = "cat_name", name = "catalog_cat_name"),
        @Index(columnList = "path", name = "catalog_path")
})
public class Catalog {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cat_name", length = Constants.SIZE_CAT_CATNAME)
    private String catName;

    @Column(name = "path", length = Constants.SIZE_CAT_PATH)
    private String path;

    @Column(name = "cat_type", nullable = false)
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
