package edu.mum.cs544;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer coursenumber;
    private String name;

    @ManyToMany(mappedBy = "courses")
    List<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        students.add(student);
    }

    public Course() {
    }

    public Course( Integer coursenumber, String name) {

        this.coursenumber = coursenumber;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCoursenumber() {
        return coursenumber;
    }

    public void setCoursenumber(Integer coursenumber) {
        this.coursenumber = coursenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name;
    }
}
