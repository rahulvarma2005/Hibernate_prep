package com.rahul;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception{
        Configuration config = new Configuration();
        config.addAnnotatedClass(com.rahul.Student.class);
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        //ADD DATA
//        Student student = new Student();
//        student.setName("Varma");
//        student.setId(13);
//        student.setTech("Python");

        //Transaction transaction = session.beginTransaction(); //needed only when saving, updating and deleting
        //session.persist(student); //this is for saving and adding data.
        // transaction.commit();


        // FETCH DATA
        //Student student = session.find(Student.class,12); //uses eager fetching(fires a query even when not printing)
        // Student student = session.byId(Student.class).getReference(12);  //uses lazy fetching(fires a query only when printing is needed)
        //System.out.println(student);

        //UPDATE DATA
        Student student = new Student();
        student.setName("Rahul");
        student.setId(12);
        student.setTech("C");

        Transaction transaction = session.beginTransaction();
        session.merge(student);
        transaction.commit();



        session.close();
        factory.close();
    }
}