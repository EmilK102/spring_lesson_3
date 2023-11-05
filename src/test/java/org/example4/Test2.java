package org.example4;

import org.example4.entity.Department;
import org.example4.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        try(SessionFactory factory = new Configuration().
                configure("hiberbate.cfg.xml").
                addAnnotatedClass(Department.class).
                addAnnotatedClass(Employee.class).
                buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Employee set name = 'Coolname' where name = 'Test3'").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Fail!");
            System.out.println(e.getMessage());
        }
    }
}
