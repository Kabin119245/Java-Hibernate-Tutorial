package org.kabin;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.util.Collection;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Configuration conf = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Laptop.class);

        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Employee emp = session.get(Employee.class, 1);
        //yeso garda employee ko matra ayo, laptop ko data aayena even if employee has multiple laptop
        //if i want collection of laptop then

        System.out.println(emp.getEname() + " " + emp.getEid());

        Collection<Laptop> laps = emp.getLaps();
        for (Laptop l : laps) {
            System.out.println(l);
        }


        session.getTransaction().commit();




    }
}
