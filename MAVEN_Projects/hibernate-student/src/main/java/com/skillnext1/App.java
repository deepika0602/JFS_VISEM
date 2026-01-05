package com.skillnext1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {
            // Insert student
            Student student = new Student("Doggy", 5, "CSE");
            session.persist(student);

            tx.commit();
            System.out.println("Student inserted successfully!");

            // Fetch students ORDER BY name
            List<Student> students = session.createQuery(
                    "FROM Student ORDER BY name", Student.class
            ).list();

            for (Student s : students) {
                System.out.println(
                        s.getId() + " "
                        + s.getName() + " "
                        + s.getSem() + " "
                        + s.getDept()
                );
            }

        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();

        } finally {
            session.close();
        }
    }
}
