package com.anuwat.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.anuwat.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
				// create session
				Session session = factory.getCurrentSession();
				
				try {
					// create 3 student object
					System.out.println("Creating new student object...");
					Student tempStudent1 = new Student("ABC","AKz","ABC.asm@localhax.exz");
					Student tempStudent2 = new Student("DEF","AKx","DEF.asm@localhax.exz");
					Student tempStudent3 = new Student("GHI","AKc","GHI.asm@localhax.exz");
					// start transaction
					session.beginTransaction();
					// save student object
					System.out.println("Saving the student...");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					// commit transaction
					session.getTransaction().commit();
					System.out.println("DONE...");
					
				} finally {
					factory.close();
				}
			}


	}


