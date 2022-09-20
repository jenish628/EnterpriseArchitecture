package edu.mum.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class App3 {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Student student = new Student(15L, "Ram", "laName");
        Student student1 = new Student( 20L, "Shyam", "laName2");
        Student student2 = new Student(30L, "Hari", "laName3");
        Student student3 = new Student(35L,"Gunna", "Reddy");

        Course course = new Course(12, "computerScience");
        Course course1 = new Course(14, "Information Science");
        Course course2 = new Course(16, "Management");

        em.persist(student);
        em.persist(student1);
        em.persist(student2);
        em.persist(student3);

        em.persist(course);
        em.persist(course1);
        em.persist(course2);

        student.AddCourse(course);
        student.AddCourse(course1);
        student3.AddCourse(course2);

        em.getTransaction().commit();

        TypedQuery<Student> studentTypedQuery = em.createQuery("from Student ", Student.class);
        List<Student> students = studentTypedQuery.getResultList();
        for (Student studentss : students){
            System.out.println("Students are: " + studentss.getFirstName()
                    + "      " + studentss.getCourses());
        }
        em.close();
    }
}
