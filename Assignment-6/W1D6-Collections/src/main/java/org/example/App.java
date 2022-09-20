package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

public class App {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf. createEntityManager();

        em.getTransaction().begin();

        Employee employee1 = new Employee("jenish", "ghimire");

        Employee employee2 = new Employee("Binod", "Pant");

        Laptop laptop1 = new Laptop("DELL", "windows");
        Laptop laptop2 = new Laptop("Apple", "mac");
        Laptop laptop3 = new Laptop("Asus", "Linux");


        em.persist(employee1);
        em.persist(employee2);
        em.persist(laptop1);
        em.persist(laptop2);
        em.persist(laptop3);

        employee1.setLaptops(List.of(laptop1, laptop2));
        employee2.setLaptops(List.of( laptop3));


//        laptop1.setEmployee(employee1);
////        laptop2.setEmployee(employee1);
////        laptop2.setEmployee(employee2);
//        laptop3.setEmployee(employee2);



        em.getTransaction().commit();

        em.getTransaction().begin();
        TypedQuery<Employee> query = em.createQuery("from Employee ", Employee.class);
        List<Employee> employees = query.getResultList();

        for (Employee employee : employees){
            System.out.println("Name:  "+ employee.getFirstName() + " " + employee.getLastName()+
                    ". Laptops with them are: " + employee.getLaptops());
        }
//        employees.forEach(System.out::println);
        em.getTransaction().commit();
        em.close();

    }
}
