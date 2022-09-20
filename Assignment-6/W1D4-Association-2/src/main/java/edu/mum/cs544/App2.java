package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App2 {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Book book = new Book(12, "Book1", "Ram");
        Book book1 = new Book(14, "Book2", "shyam");
        Book book2 = new Book(16,"Book3", "Hari");

        Publisher publisher = new Publisher("EKTA");
        Publisher publisher1 = new Publisher("WORLD");
        Publisher publisher2 = new Publisher("NEPAL");

        em.persist(book);
        em.persist(book1);
        em.persist(book2);
        em.persist(publisher);
        em.persist(publisher1);
        em.persist(publisher2);

        book.setPublisher(publisher);
        book1.setPublisher(publisher1);
        book2.setPublisher(publisher1);


        em.getTransaction().commit();


        TypedQuery<Book> query = em.createQuery("from Book ", Book.class);
        List<Book> bookList = query.getResultList();
        for (Book books : bookList){
            System.out.println("Books are: "+ books.getAuthor());

        }
    }
}
