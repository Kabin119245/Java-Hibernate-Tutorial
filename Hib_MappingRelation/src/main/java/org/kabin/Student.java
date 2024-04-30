package org.kabin;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id //primary key
    private int rollno;
    private String name;
    private int marks;

//    @OneToOne //one student has one laptop
//    private Laptop laptop;

    //now one to many; one student has many laptops

//    @OneToMany(mappedBy = "student")
//    private List<Laptop> laptop = new ArrayList<>();

    //ManytoMany

    @ManyToMany(mappedBy = "student")
    private List<Laptop> laptop = new ArrayList<>();


    //so the Student table will have lid as foreign key because it is primary key of laptop table

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }


    public List<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
