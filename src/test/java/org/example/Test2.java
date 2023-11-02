package org.example;

import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().
                configure("hiberbate.cfg.xml").
                addAnnotatedClass(Employee.class).
                buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Test", "user", "IT", 100_000);
            session.beginTransaction();
            session.persist(employee);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee1 = session.get(Employee.class, employee.getId());
            session.getTransaction().commit();

            System.out.println(employee1.toString());

        } catch (Exception e) {
            System.out.println("Fail!");
            System.out.println(e.getMessage());
        }
    }
}
