package org.kabin;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Collection;

@Entity

public class Employee {

    @Id
    private int eid;
    private String ename;

    //in this case one employee can have many laptops

    //by default fetch type is lazy we can make it Eager
    @OneToMany(mappedBy="employee", fetch = FetchType.EAGER)
    private Collection<Laptop> laps = new ArrayList<Laptop>();


    public Collection<Laptop> getLaps() {
        return laps;
    }

    public void setLaps(Collection<Laptop> laps) {
        this.laps = laps;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                '}';
    }
}
