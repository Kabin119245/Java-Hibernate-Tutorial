package org.kabin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class Main {
    public static void main(String[] args) {


        Alien kabin = new Alien();
        kabin.setAid(106);
        kabin.setAname("Laxmi");
        kabin.setColor("Cyan");

        Configuration conf = new Configuration().configure().addAnnotatedClass(Alien.class);
        // A Configuration object is created, which represents the configuration settings for Hibernate. .configure() method loads the hibernate.cfg.xml file (if exists) to configure Hibernate. .addAnnotatedClass(Alien.class) adds the Alien class as an annotated class to the configuration, indicating that it will be managed by Hibernate

        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

        SessionFactory sf = conf.buildSessionFactory(sr);

        Session session = sf.openSession();

        //in older version: session.save(kabin);
        Transaction  tx = session.beginTransaction();
        session.persist(kabin);

        tx.commit();



    }
}