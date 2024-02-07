package fr.fms.business;

import java.util.ArrayList;
import java.util.HashMap;

import fr.fms.dao.CategoryDao;
import fr.fms.dao.TrainingCourseDao;
import fr.fms.entities.Category;
import fr.fms.entities.TrainingCourse;

public class IBusinessImpl implements IBusiness{

	private static HashMap<Integer, TrainingCourse> cart = new HashMap<Integer, TrainingCourse>();
	private static TrainingCourseDao trainingCourseDao = new TrainingCourseDao();
	private static CategoryDao categoryDao = new CategoryDao();
	
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
		//TrainingCourse tc = cart.get(id);
		cart.remove(id);
		
	}

	@Override
	public int takeOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<TrainingCourse> showTrainingCourseList() {
		return trainingCourseDao.readAll();
	}

	@Override
	public TrainingCourse showTrainingCourse(int id) {
		
		return trainingCourseDao.read(id);
	}

	@Override
	public ArrayList<Category> readCategories() {
		return categoryDao.readAll();
	}

	
}
