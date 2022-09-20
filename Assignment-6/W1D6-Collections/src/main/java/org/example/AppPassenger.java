package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class AppPassenger {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Passenger p1 = new Passenger("Ram");

        Passenger p2 = new Passenger("Shayam");

        Passenger p3 = new Passenger("Hari");

        Flight flight1 = new Flight(100, "brt", "ktm", LocalDate.now());

        Flight flight2 = new Flight(200, "ktm", "pkh", LocalDate.of(2022, 4, 4));



        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(flight1);
        em.persist(flight2);

        p1.addFlight(flight1);
        p1.addFlight(flight2);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Passenger> query = em.createQuery("from Passenger", Passenger.class);
        List<Passenger> passengers = query.getResultList();

        for (Passenger passenger: passengers){
            System.out.println("The passengers are: " + passenger.getName()+" " + passenger.getClass());
        }
    }
}
