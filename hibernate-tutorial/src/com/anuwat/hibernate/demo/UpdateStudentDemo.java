package com.anuwat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anuwat.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			int studentId = 1;

			System.out.println("\nGetting student with ID: " + studentId);
			
			
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Get Complete: " + myStudent);
			
			
			System.out.println("Update student... ");
			myStudent.setFirstName("Scooby");
			// commit transaction
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			// update email for all student
			System.out.println(" update email for all student ");
			
			
			session.createQuery("update Student set email='hacked'").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("DONE...");

		} finally {
			factory.close();
		}
	}

}
