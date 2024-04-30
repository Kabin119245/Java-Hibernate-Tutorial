package org.kabin;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Laptop {

    @Id //for primary key
    private int lid;
    private String lname;



//    @ManyToOne
//    private Student student;

    @ManyToMany
    private List<Student> student = new ArrayList<Student>();

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
}
