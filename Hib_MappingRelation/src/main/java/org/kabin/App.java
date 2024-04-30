package org.kabin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {


        //fetchData();
        putData();
    }

    public static void putData() {


        Laptop laptop = new Laptop();
        laptop.setLid(101);
        laptop.setLname("Dell");



        Student stud = new Student();

        laptop.getStudent().add(stud);



        stud.setRollno(1);
        stud.setName("Kabin");
        stud.setMarks(85);
        //stud.setLaptop(laptop);

        stud.getLaptop().add(laptop);


        Configuration conf = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        // A Configuration object is created, which represents the configuration settings for Hibernate. .configure() method loads the hibernate.cfg.xml file (if exists) to configure Hibernate. .addAnnotatedClass(Alien.class) adds the Alien class as an annotated class to the configuration, indicating that it will be managed by Hibernate

        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

        SessionFactory sf = conf.buildSessionFactory(sr);

        Session session = sf.openSession();

        //in older version: session.save(kabin);
        Transaction tx = session.beginTransaction();
        session.persist(laptop);
        session.persist(stud);

        tx.commit();




    }


}
