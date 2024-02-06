package fr.fms.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import fr.fms.entities.TrainingCourse;

public class TrainingCourseDao implements Dao<TrainingCourse> {

	@Override
	public void create(TrainingCourse obj) {
		
		
	}

	@Override
	public TrainingCourse read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(TrainingCourse obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(TrainingCourse obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<TrainingCourse> readAll() {
		String requestSql = "SELECT * FROM T_TrainingCourses;";
		try(Statement st = connection.createStatement()) {
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return null;
	}

	
}
