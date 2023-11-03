package org.example;

import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().
                configure("hiberbate.cfg.xml").
                addAnnotatedClass(Employee.class).
                buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("delete Employee where name='Test'").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Fail!");
            System.out.println(e.getMessage());
        }
    }
}
