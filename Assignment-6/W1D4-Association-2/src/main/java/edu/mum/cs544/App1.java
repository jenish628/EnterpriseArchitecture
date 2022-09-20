package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

public class App1 {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Department department1 = new Department("COMPUTER");
        Department department2 = new Department("MANAGEMENT");

        Employee employee = new Employee("aaa");
        Employee employee1 = new Employee("bbb");
        Employee employee2 = new Employee("ccc");
        Employee employee3 = new Employee("ddd");

        Office office = new Office(12, 25);
        Office office1 = new Office( 56, 68);

        em.persist(office);
        em.persist(office1);

        office.addEmployee(employee);
        office.addEmployee(employee3);


        department1.addEmployee(employee);
        department1.addEmployee(employee1);
        employee.setDepartment(department1);
        employee1.setDepartment(department2);

        em.persist(department1);
        em.persist(department2);




        em.getTransaction().commit();

        TypedQuery<Department> query = em.createQuery("from Department ", Department.class);
        List<Department> departments = query.getResultList();
        for (Department department : departments){
            System.out.println("The Departments are: "+ department.getName()
            + "and the employees are: " + department.getEmployees());
        }

    }
}
