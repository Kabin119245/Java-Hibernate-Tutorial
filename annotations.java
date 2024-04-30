package org.kabin;

import java.beans.Transient;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Table(name = "alien_table") // for table name by default Alien(classname)
public class Alien { // POJO

    @Id
    private int aid;
    // if i dont want to store name in table then @Transient is used
    @Transient
    private String aname;

    @Column(name = "alien_color") // for column name, default is color but it is defined explicitly
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
