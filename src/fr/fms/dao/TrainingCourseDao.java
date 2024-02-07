package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import fr.fms.entities.TrainingCourse;

public class TrainingCourseDao implements Dao<TrainingCourse> {

	private static ArrayList<TrainingCourse> trainingCourses = new ArrayList<TrainingCourse>();
	private static ArrayList<TrainingCourse> tcFilter = new ArrayList<TrainingCourse>();
	//private static ArrayList<TrainingCourse> tcByKey = new ArrayList<TrainingCourse>();
	
	/**
	 * Méthode qui créé une formation en base de données dont l'id est généré automatiquement.
	 */
	@Override
	public void create(TrainingCourse obj) {
		String create = "INSERT INTO T_TrainingCourses (Name, Description, Duration, Type, Price) VALUES (?,?,?,?,?);";
		try(PreparedStatement ps = connection.prepareStatement(create)) {
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getDescription());
			ps.setInt(3, obj.getDuration());
			ps.setString(4, obj.getType());
			ps.setDouble(5, obj.getPrice());
			if(ps.executeUpdate() == 1)
				System.out.println("La formation a bien été créée");
		} catch (SQLException e) {
			logger.severe("Problème de création de la formation : " + e.getMessage());
		}
		
	}

	/**
	 * Méthode permettant d'afficher une formation selon son id.
	 */
	@Override
	public TrainingCourse read(int id) {
		TrainingCourse trainingCourse = null;
		String readTc = "SELECT IdTrainingCourse, Name, Description, Duration, Type, Price FROM T_TrainingCourses WHERE IdTrainingCourse = ?;";
		try(PreparedStatement ps = connection.prepareStatement(readTc)) {
			ps.setInt(1, id);
			try(ResultSet resultSet = ps.executeQuery()){
				if(resultSet.next()) {
					int rsIdTrainingCourse = resultSet.getInt("IdTrainingCourse");
					String rsName = resultSet.getString("Name");
					String rsDescription = resultSet.getString("Description");
					int rsDuration = resultSet.getInt("Duration");
					String rsType = resultSet.getString("Type");
					double rsPrice = resultSet.getDouble("Price");
					
					System.out.println("Article trouvé");
					return trainingCourse = new TrainingCourse(rsIdTrainingCourse, rsName, rsDescription, rsDuration, rsType, rsPrice);
				}else
					System.out.println("Article non trouvé");
			}
			
		} catch (SQLException e) {
			logger.severe("La formation n'existe pas " + e.getMessage());
		}
		return trainingCourse;
	}

	/**
	 * Méthode qui met à jour la formation puis renvoie si la modification est prise en compte.
	 */
	@Override
	public boolean update(TrainingCourse obj) {
		String updateTc = "UPDATE T_TrainingCourses SET IdTrainingCourse = ?, Name = ?, Description = ?, "
							+ "Duration = ?, Type = ?, Price = ?, IdCategory = ? WHERE IdTrainingCourse = ?;";
		try(PreparedStatement ps = connection.prepareStatement(updateTc)) {
			ps.setInt(1, obj.getIdTrainingCourse());
			ps.setString(2, obj.getName());
			ps.setString(3, obj.getDescription());
			ps.setInt(4, obj.getDuration());
			ps.setString(5, obj.getType());
			ps.setDouble(6, obj.getPrice());
			ps.setInt(7, obj.getIdCategory());
			ps.setInt(8, obj.getIdTrainingCourse());
			if(ps.executeUpdate() == 1) {
				System.out.println("La formation a bien été mise à jour");
				return true;
			}
		} catch (Exception e) {
			logger.severe("Problème à la mise à jour : " + e.getMessage());
		}
		return false;
	}

	/**
	 * Méthode permettant de supprimer une formation en base
	 * renvoie si la formation a bien été supprimée.
	 */
	@Override
	public boolean delete(TrainingCourse obj) {
		String deleteTc = "DELETE FROM T_TrainingCourses WHERE IdTrainingCourse = ?;";
		try(PreparedStatement ps = connection.prepareStatement(deleteTc)){
			ps.setInt(1, obj.getIdTrainingCourse());
			if(ps.executeUpdate() == 1) {
				System.out.println("Suppréssion de la formation effectuée");
				return true;
			}
		}catch(SQLException e) {
			logger.severe("Problème de suppression de la formation : " + e.getMessage());
		}
		return false;
	}

	/**
	 * Méthode qui séléctionne toutes les formations en base puis les ajoute à la liste
	 * et renvoie la liste de formations.
	 */
	@Override
	public ArrayList<TrainingCourse> readAll() {
		String requestSql = "SELECT * FROM T_TrainingCourses;";
		try(Statement st = connection.createStatement()) {
			try(ResultSet resultSet = st.executeQuery(requestSql)){
				while(resultSet.next()) {
					int rsIdTrainingCourse = resultSet.getInt("IdTrainingCourse");
					String rsName = resultSet.getString("Name");
					String rsDescription = resultSet.getString("Description");
					int rsDuration = resultSet.getInt("Duration");
					String rsType = resultSet.getString("Type");
					double rsPrice = resultSet.getDouble("Price");
					trainingCourses.add(new TrainingCourse(rsIdTrainingCourse, rsName, rsDescription, rsDuration, rsType, rsPrice));
				}
			}
		} catch (SQLException e) {
			logger.severe("Problème d'accès aux données : " + e.getMessage());
		}
		return trainingCourses;
	}

	/**
	 * Méthode permettant de sélectionner les formations d'une catégorie en base
	 * puis les ajoute à une liste dont celle-ci est retournée par la méthode.
	 */
	@Override
	public ArrayList<TrainingCourse> readAllByCategory(int id) {
		String requestFilter = "SELECT IdTrainingCourse, Name, T_TrainingCourses.Description, Duration, Type, Price FROM T_TrainingCourses "
				+ "INNER JOIN T_Categories ON T_TrainingCourses.IdCategory = T_Categories.IdCategory WHERE T_Categories.IdCategory = ?;";
		try(PreparedStatement ps = connection.prepareStatement(requestFilter)) {
			ps.setInt(1, id);
			try(ResultSet resultSet = ps.executeQuery()){
				while(resultSet.next()) {
					int rsIdTrainingCourse = resultSet.getInt("IdTrainingCourse");
					String rsName = resultSet.getString("Name");
					String rsDescription = resultSet.getString("Description");
					int rsDuration = resultSet.getInt("Duration");
					String rsType = resultSet.getString("Type");
					double rsPrice = resultSet.getDouble("Price");
					tcFilter.add(new TrainingCourse(rsIdTrainingCourse, rsName, rsDescription, rsDuration, rsType, rsPrice));
				}
			}
		} catch (SQLException e) {
			logger.severe("Problème d'accès aux données : " + e.getMessage());
		}
		return tcFilter;
	}
	/*
	@Override
	public ArrayList<TrainingCourse> searchTcByKey(String word) {
		String searchTc = "SELECT * FROM T_TrainingCourses WHERE Name LIKE '?%';";
		try(PreparedStatement ps = connection.prepareStatement(searchTc)) {
			ps.setString(1, word);
			//ps.setString(2, word);
			//ps.setString(3, word);
			try(ResultSet resultSet = ps.executeQuery()){
				while(resultSet.next()) {
					int rsIdTrainingCourse = resultSet.getInt("IdTrainingCourse");
					String rsName = resultSet.getString("Name");
					String rsDescription = resultSet.getString("Description");
					int rsDuration = resultSet.getInt("Duration");
					String rsType = resultSet.getString("Type");
					double rsPrice = resultSet.getDouble("Price");
					tcByKey.add(new TrainingCourse(rsIdTrainingCourse, rsName, rsDescription, rsDuration, rsType, rsPrice));
				}
			}
		} catch (SQLException e) {
			logger.severe("Problème d'accès aux données : " + e.getMessage());
		}
		return null;
	}	
	*/
}
