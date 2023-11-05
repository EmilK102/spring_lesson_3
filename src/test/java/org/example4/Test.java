package org.example4;

import org.example4.entity.Department;
import org.example4.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Test1", "user", 700);
        Employee employee2 = new Employee("Test2", "user", 800);
        Employee employee3 = new Employee("Test3", "user", 600);

        Department department = new Department("IT", 1000, 500);


        try(SessionFactory factory = new Configuration().
                configure("hiberbate.cfg.xml").
                addAnnotatedClass(Department.class).
                addAnnotatedClass(Employee.class).
                buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            department.addEmployeeToDepartment(employee1);
            department.addEmployeeToDepartment(employee2);
            department.addEmployeeToDepartment(employee3);
            session.persist(department);
            session.getTransaction().commit();

        } catch (Exception e){
            System.out.println();
        }
    }
}
