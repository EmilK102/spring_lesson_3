package org.example2;

import org.example2.entity.Detail;
import org.example2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {

        Detail detail = new Detail("Tokyo", "+88005553535", "example@mail.com");
        Employee employee = new Employee("Test", "User", "IT", 900, detail);

        try(SessionFactory factory =  new Configuration().
                configure("hiberbate.cfg.xml").
                addAnnotatedClass(Detail.class).
                addAnnotatedClass(Employee.class).
                buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.persist(employee);
            session.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println("Fail!");
            System.out.println(e.getMessage());
        }
    }
}
