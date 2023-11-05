package org.example4;

import org.example4.entity.Department;
import org.example4.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test3 {
    public static void main(String[] args) {
        Employee employee1 = new Employee("User21", "Test", 500);
        Employee employee2 = new Employee("User22", "Test", 600);
        Department department = new Department("IT2", 600,500);

        department.addEmployeeToDepartment(employee1);
        department.addEmployeeToDepartment(employee2);
        try(SessionFactory factory = new Configuration().
                configure("hiberbate.cfg.xml").
                addAnnotatedClass(Department.class).
                addAnnotatedClass(Employee.class).
                buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.persist(department);
            System.out.println("____________");
            session.remove(employee1);
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Fail!");
            System.out.println(e.getMessage());
        }
    }
}
