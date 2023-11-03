package org.example;

import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test4 {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().
                configure("hiberbate.cfg.xml").
                addAnnotatedClass(Employee.class).
                buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 1);
//            employee.setSalary(150_000);
            session.createQuery("update Employee set salary=1000 where name='Test'").executeUpdate();
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Fail!");
            System.out.println(e.getMessage());
        }
    }
}
