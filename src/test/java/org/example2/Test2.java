package org.example2;

import org.example2.entity.Detail;
import org.example2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {

        try(SessionFactory factory =  new Configuration().
                configure("hiberbate.cfg.xml").
                addAnnotatedClass(Detail.class).
                addAnnotatedClass(Employee.class).
                buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 3);
            System.out.println(employee.getDetails());
            session.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println("Fail!");
            e.printStackTrace();
        }
    }
}
