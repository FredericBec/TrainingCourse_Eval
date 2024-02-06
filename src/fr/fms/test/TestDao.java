package fr.fms.test;

import fr.fms.dao.TrainingCourseDao;
import fr.fms.entities.TrainingCourse;

public class TestDao {

	public static void main(String[] args) {
		TrainingCourseDao trainingCourseDao = new TrainingCourseDao();
		
		for(TrainingCourse t : trainingCourseDao.readAll())
			System.out.println(t.getIdTrainingCourse() + " - " + t.getName() + " - " + t.getDescription() 
												+ " - " + t.getDuration() + " - " + t.getPrice());

		//trainingCourseDao.create(new TrainingCourse("Angular", "frameworks front end", 10, "Distanciel", 750.0));
		
		TrainingCourse trainingCourse = trainingCourseDao.read(6);
		System.out.println(trainingCourse);
		
		trainingCourse.setIdCategory(3);
		trainingCourseDao.update(trainingCourse);
		
		trainingCourseDao.delete(trainingCourse);
	}

}
