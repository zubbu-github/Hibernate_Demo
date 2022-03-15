package com.hibrnate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import com.hibernate.project1.User;
import com.hibernate.project1.Users;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Users.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//Users user = new Users(3,"Hrithik","Roshan","hrithik@gmail.com");
			User user = new User();
			
			session.beginTransaction();
			
			user = session.get(User.class, 1);
			
			user.setUser_fname("MOM");
			user.setUser_lname("DAD");
			
			session.save(user);
			
			session.getTransaction().commit();
			//System.out.println("Row Added");
			System.out.println(user);
			
			
		}finally {
			session.close();
			factory.close();
		}

	}

}
