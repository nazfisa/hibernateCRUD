package demo;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class CreateStudentDemo {

        public static void main(String[] args) {

            // create session factory
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create a student object
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("hook", "Doe", "hook@luv2code.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		}
		finally {
			session.close();
			factory.close();
		}

//            Configuration configuration = new Configuration()
//                    .configure()
//                    .addAnnotatedClass(Student.class);
//            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//            Session session = sessionFactory.getCurrentSession();
//            try {
//                System.out.println("Creating new student object...");
//                Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");
//
//                // start a transaction
//                session.beginTransaction();
//
//                // save the student object
//                System.out.println("Saving the student...");
//                session.save(tempStudent);
//
//                // commit transaction
//                session.getTransaction().commit();
//
//                System.out.println("Done!");
//
//            }finally {
//                session.close();
//                sessionFactory.close();
//            }
        }

    }







