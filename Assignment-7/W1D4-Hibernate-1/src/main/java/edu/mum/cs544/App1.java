package edu.mum.cs544;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Set;

public class App1 {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Customer customer = new Customer("Ram", "Rlname");
        Customer customer1 = new Customer("Shyam", "Slname");
        Customer customer2 = new Customer("Hari","Hlname");

        Order order = new Order(LocalDate.now());
        Order order1 = new Order(LocalDate.of(2000, 1, 1));
        Order order2 = new Order(LocalDate.of(2222, 1, 1));

        OrderLine orderLine = new OrderLine(25);
        OrderLine orderLine1 = new OrderLine(30);
        OrderLine orderLine2 = new OrderLine(45);

        Product product = new Product("Bikes", "The two wheller");
        Product product1 = new Product("Cars", "The four wheller");
        Product product2 = new Product("Subaru", "The Mama's bike");

        Book book = new Book("BookTitle");
        Book book1 = new Book("Bike", "2-whellers", "jenishTitle");
        em.persist(book);
        em.persist(book1);


        customer.addOrder(order);
        customer.addOrder(order1);

        customer.setSage(28);
        customer.setDob(LocalDate.now());
        customer.setSname("jenish");

        em.persist(customer);
        em.persist(customer1);
        em.persist(customer2);
        em.persist(order);
        em.persist(order1);
        em.persist(order2);
        em.persist(orderLine);
        em.persist(orderLine1);
        em.persist(orderLine2);
        em.persist(product);
        em.persist(product1);
        em.persist(product2);


        order.setOrderLines(Set.of(orderLine, orderLine1));

        orderLine.setProduct(product);
        orderLine1.setProduct(product);
        orderLine2.setProduct(product);

        em.getTransaction().commit();
        em.close();
    }
}
