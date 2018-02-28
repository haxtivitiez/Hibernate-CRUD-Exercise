package com.anuwat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anuwat.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save Java object
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Sillly","Adpo","Sillly.asm@localhax.exz");
			// start transaction
			session.beginTransaction();
			// save student object
			System.out.println("Saving the student... ");
			System.out.println(tempStudent);
			session.save(tempStudent);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Saving the student..Generate ID: "+tempStudent.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student base on id: primary key
			System.out.println("\nGetting student with id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			
			System.out.println("Get Complete: " + myStudent);
			
			// commit
			session.getTransaction().commit();
			
			
			System.out.println("DONE...");
			
		} finally {
			factory.close();
		}
	}

}
