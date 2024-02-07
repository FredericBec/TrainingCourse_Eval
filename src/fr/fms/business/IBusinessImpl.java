package fr.fms.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import fr.fms.dao.CategoryDao;
import fr.fms.dao.CustomerDao;
import fr.fms.dao.OrderDao;
import fr.fms.dao.OrderItemDao;
import fr.fms.dao.TrainingCourseDao;
import fr.fms.entities.Category;
import fr.fms.entities.Order;
import fr.fms.entities.OrderItem;
import fr.fms.entities.TrainingCourse;

public class IBusinessImpl implements IBusiness{

	private static HashMap<Integer, TrainingCourse> cart = new HashMap<Integer, TrainingCourse>();
	private static TrainingCourseDao trainingCourseDao = new TrainingCourseDao();
	private static CategoryDao categoryDao = new CategoryDao();
	private static CustomerDao customerDao = new CustomerDao();
	private static OrderDao orderDao = new OrderDao();
	private static OrderItemDao orderItemDao = new OrderItemDao();
	
	@Override
	public void addToCart(TrainingCourse obj) {
		cart.put(obj.getIdTrainingCourse(), obj);
		
	}

	@Override
	public ArrayList<TrainingCourse> showCart() {
		return new ArrayList<TrainingCourse>(cart.values());
		
	}

	@Override
	public void deleteFromCart(int id) {
		cart.remove(id);
		
	}

	@Override
	public int takeOrder(int idCustomer) {
		if(customerDao.read(idCustomer) != null) {
			double totalAmount = getTotalAmount();
			Order order = new Order(customerDao.read(idCustomer).getName(), totalAmount, new Date());
			orderDao.create(order);
			for(TrainingCourse t : cart.values())
				orderItemDao.create(new OrderItem(t.getPrice(), t.getIdTrainingCourse(), order.getIdOrder()));
			return order.getIdOrder();
		}
		return 0;
	}

	@Override
	public ArrayList<TrainingCourse> readTrainingCourseList() {
		return trainingCourseDao.readAll();
	}

	@Override
	public TrainingCourse readTrainingCourse(int id) {
		return trainingCourseDao.read(id);
	}

	@Override
	public ArrayList<TrainingCourse> readTrainingCourseListByCategory(int id) {
		return trainingCourseDao.readAllByCategory(id);
	}
	
	@Override
	public ArrayList<Category> readCategories() {
		return categoryDao.readAll();
	}

	public double getTotalAmount() {
		double [] totalAmount = {0};
		cart.values().forEach((a) -> totalAmount[0] += a.getPrice());
		
		return totalAmount[0];
	}
	
}
