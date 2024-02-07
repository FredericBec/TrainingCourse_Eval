package fr.fms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Category;

public class CategoryDao implements Dao<Category> {

	private static ArrayList<Category> categories = new ArrayList<Category>();
	@Override
	public void create(Category obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Category obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Category obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Category> readAll() {
		String requestSql = "SELECT * FROM T_Categories;";
		try(Statement st = connection.createStatement()) {
			try(ResultSet resultSet = st.executeQuery(requestSql)){
				while(resultSet.next()) {
					int rsIdTrainingCourse = resultSet.getInt("IdCategory");
					String rsName = resultSet.getString("CatName");
					String rsDescription = resultSet.getString("Description");
					categories.add(new Category(rsIdTrainingCourse, rsName, rsDescription));
				}
			}
		} catch (SQLException e) {
			logger.severe("Problème d'accès aux données : " + e.getMessage());
		}
		return categories;
	}

}
