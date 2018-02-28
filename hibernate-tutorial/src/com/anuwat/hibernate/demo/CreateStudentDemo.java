package com.anuwat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anuwat.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
			Student tempStudent = new Student("Anuwat","AK","anuwat.asm@localhax.exz");
			// start transaction
			session.beginTransaction();
			// save student object
			System.out.println("Saving the student...");
			session.save(tempStudent);
			// commit transaction
			session.getTransaction().commit();
			System.out.println("DONE...");
			
		} finally {
			factory.close();
		}
	}

}
