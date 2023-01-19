package mcs.opds.scan;

import mcs.opds.scan.models.Author;
import mcs.opds.scan.models.Book;
import mcs.opds.scan.models.Catalog;
import mcs.opds.scan.models.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunApp {

    public static void main(String[] args) {
        bookExample();
    }

    private static void bookExample() {
        Configuration configuration = new Configuration().addAnnotatedClass(Book.class)
                .addAnnotatedClass(Author.class).addAnnotatedClass(Catalog.class)
                .addAnnotatedClass(Genre.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.getTransaction().commit();
        }
    }


}
