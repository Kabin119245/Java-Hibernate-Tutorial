package org.kabin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        users user = null;

        Configuration conf = new Configuration().configure().addAnnotatedClass(users.class);

        SessionFactory sf = conf.buildSessionFactory();
        Session session1 = sf.openSession();

        //SESSION 1
        session1.beginTransaction();

        user = (users)  session1.get(users.class,1);
        System.out.println(user);

        //if we again want to print the same value then it will fire the query only once and print two rows(values)

//        user = (users)  session1.get(users.class,1);
//        System.out.println(user);
        //First Level Cache, but availabe in only inside same session

        session1.getTransaction().commit();

        session1.close();

        //SESSION 2 (if we want in different session then we need Second Level Cache)
        //using ehcache

        Session session2 = sf.openSession();
        session2.beginTransaction();

        user = (users)  session2.get(users.class,1);
        System.out.println(user);


        session2.getTransaction().commit();
        session2.close();



    }
}
