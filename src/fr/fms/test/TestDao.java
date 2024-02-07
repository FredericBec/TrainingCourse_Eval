package fr.fms.test;

import java.sql.Date;

import fr.fms.dao.CategoryDao;
import fr.fms.dao.CustomerDao;
import fr.fms.dao.OrderDao;
import fr.fms.dao.OrderItemDao;
import fr.fms.dao.TrainingCourseDao;
import fr.fms.dao.UserDao;
import fr.fms.entities.Customer;
import fr.fms.entities.Order;
import fr.fms.entities.OrderItem;
import fr.fms.entities.TrainingCourse;
import fr.fms.entities.User;

public class TestDao {

	public static void main(String[] args) {
		
		//Test du composant TrainingCourseDao
		TrainingCourseDao trainingCourseDao = new TrainingCourseDao();
		
		for(TrainingCourse t : trainingCourseDao.readAll())
			System.out.println(t.getIdTrainingCourse() + " - " + t.getName() + " - " + t.getDescription() 
												+ " - " + t.getDuration() + " - " + t.getPrice());
		
		System.out.println("\n-----------------------------------------\n");

		//trainingCourseDao.create(new TrainingCourse("Angular", "frameworks front end", 10, "Distanciel", 750.0));
		/*
		TrainingCourse trainingCourse = trainingCourseDao.read(6);
		System.out.println(trainingCourse);
		
		trainingCourse.setIdCategory(3);
		trainingCourseDao.update(trainingCourse);
		
		trainingCourseDao.delete(trainingCourse);
		*/
		
		trainingCourseDao.readAllByCategory(3).stream().forEach(System.out::println);
		System.out.println("\n-----------------------------------------\n");
		//Test du composant CategoryDao
		CategoryDao categories = new CategoryDao();
		
		categories.readAll().stream().forEach(System.out::println);
		
		System.out.println("\n-----------------------------------------\n");
		//Test de UserDao
		UserDao users = new UserDao();
		//User fred = new User("Frederic", "BmI4@e40D");
		//User alejandra = new User("Alejandra", "M3x1C@n0!");
		//User donovan = new User("donovan","R0c1St4r!");
		//users.create(fred);
		//users.create(alejandra);
		//users.create(donovan);
		
		users.readAll().stream().forEach(System.out::println);
		
		System.out.println(users.read(2));
		//User fred = users.read(1);
		//fred.setLogin("Fred");
		//users.update(fred);
		
		//users.delete(users.read(3));
		
		System.out.println("\n-----------------------------------------\n");
		//Test de CustomerDao
		CustomerDao customers = new CustomerDao();
		//Customer customer = new Customer("bec", "frederic", "6 rue des devs 75000 Paris", "bec.frederic@gmail.com", "0768247955", 1);
		//customers.create(customer);
		
		customers.readAll().stream().forEach(System.out::println);
		
		Customer fred = customers.read(7);
		
		System.out.println(fred);
		
		
		
		System.out.println("\n-----------------------------------------\n");
		//Test de OrderDao
		OrderDao orders = new OrderDao();
		Order order = new Order(customers.read(1).getName(), 1000.0, new Date(2024, 2, 7));
		
		//orders.create(order);
		
		System.out.println("\n-----------------------------------------\n");
		//Test de OrderItemDao
		OrderItemDao orderItems = new OrderItemDao();
		
		OrderItem orderItem = new OrderItem(1000.0, 1, 2);
		
		//orderItems.create(orderItem);
		
	}

}
