package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AppSchool {

    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        School school1 = new School("Maharishi International University");

        School school2 = new School("Cosomos");

        Student s1 = new Student(123L, "Ram", "Pant");
        Student s2 = new Student(456L, "Hari", "Karki");
        Student s3 = new Student(789L, "Shyam", "Shrestha");

        em.persist(school1);
        em.persist(school2);
        em.persist(s1);
        em.persist(s2);
        em.persist(s3);

        school1.addStudent(s1);
        school1.addStudent(s2);
        school2.addStudent(s3);



        em.getTransaction().commit();

        TypedQuery<School> query = em.createQuery("from School ", School.class);
        List<School> schools = query.getResultList();
        for (School school : schools){
            System.out.println("The schools are " + school.getName()
            + "and the students details are " + school.getStudents());
        }


    }

}
