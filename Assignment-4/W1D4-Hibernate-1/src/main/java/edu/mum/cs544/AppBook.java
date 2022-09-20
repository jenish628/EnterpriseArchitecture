package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class AppBook {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Book book1 = new Book("cs","cs150","james",540,new Date());
        em.persist(book1);
        Book book2 = new Book("it", "it150", "jenith", 540, new Date());
        em.persist(book2);
        Book book3 = new Book("mgmt", "mgmt150", "cooper", 400, new Date(1998, 8, 8 ));
        em.persist(book3);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Book> book = em.createQuery("from Book ", Book.class);
        List<Book> bookList = book.getResultList();
        bookList.forEach(System.out::println);
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Book> books = em.createQuery("from Book ", Book.class);
        List<Book> bookList1 = books.getResultList();
        Book bookRemove = bookList1.get(2);
        em.remove(bookRemove);
        bookRemove.setTitle("mgmtedited");
        bookRemove.setPrice(500);
        em.persist(bookRemove);

        em.getTransaction().commit();

        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Book> bookss = em.createQuery("from Book ",Book.class);
        List<Book> bookList2 = bookss.getResultList();
        bookList2.forEach(System.out::println);

        em.close();
    }
}
