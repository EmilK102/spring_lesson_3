package org.example;

import org.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().
                configure("hiberbate.cfg.xml").
                addAnnotatedClass(Employee.class).
                buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            List<Employee> employeeList = session.createQuery("from Employee where name = 'Test' and salary > 6000").
                    getResultList();

            for (Employee e: employeeList){
                System.out.println(e);
            }

            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("Fail!");
            System.out.println(e.getMessage());
        }
    }
}
