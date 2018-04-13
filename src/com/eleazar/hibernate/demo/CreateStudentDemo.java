package com.eleazar.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.eleazar.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		// Use the session object to save Java Object
		try {
			
			// Create a student object
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Eleazar", "Ponce", "poncebe@gmail.com");
			
			// Start a transaction
			session.beginTransaction();
			
			// Save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent);
		
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			
		}
		
	}

}
