package edu.mum.cs544;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id

    private Long studentid;
    private String firstName;
    private String lastName;

    @ManyToMany

    List<Course> courses = new ArrayList<>();

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void AddCourse(Course course){
        courses.add(course);
        course.addStudent(this);
    }

    public Student() {
    }

    public Student( Long studentid, String firstName, String lastName) {
        this.studentid = studentid;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
