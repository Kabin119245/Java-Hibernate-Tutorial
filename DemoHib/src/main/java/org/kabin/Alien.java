package org.kabin;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Alien {   //POJO

    @Id
    private int aid;
    private String aname;
    private String color;

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }
}
