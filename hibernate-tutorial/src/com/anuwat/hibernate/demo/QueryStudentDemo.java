package com.anuwat.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anuwat.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			// query students

			List<Student> theStudents = session.createQuery("from Student").getResultList();

			// display student

			displayStudent(theStudents);

			theStudents = session.createQuery("from Student s where s.lastName='AK'").getResultList();

			// display student
			
			System.out.println("\n\nStudent who have last name of AK");

			displayStudent(theStudents);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("DONE...");

		} finally {
			factory.close();
		}
	}

	private static void displayStudent(List<Student> theStudents) {
		for (Student tempSudent : theStudents) {
			System.out.println(tempSudent);

		}
	}

}
