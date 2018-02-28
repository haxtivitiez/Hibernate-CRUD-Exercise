package com.anuwat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anuwat.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			// del student
//			System.out.println("\nDeleting student with ID: " + myStudent);
//			session.delete(myStudent);
			
			// another way
			System.out.println("delete from Student where id=2");
			session.createQuery("delete from Student where id=2").executeUpdate();
		
			// commit transaction
			session.getTransaction().commit();
			
		

			System.out.println("DONE...");

		} finally {
			factory.close();
		}
	}

}
