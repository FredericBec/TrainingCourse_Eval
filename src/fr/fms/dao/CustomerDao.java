package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Customer;

public class CustomerDao implements Dao<Customer>{

	private ArrayList<Customer> customers = new ArrayList<Customer>();
	
	@Override
	public void create(Customer obj) {
		String create = "INSERT INTO T_Customers (Name, FirstName, Address, Email, Phone, IdUser) VALUES (?,?,?,?,?,?);";
		try(PreparedStatement ps = connection.prepareStatement(create)) {
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getFirstName());
			ps.setString(3, obj.getAddress());
			ps.setString(4, obj.getEmail());
			ps.setString(5, obj.getPhone());
			ps.setInt(6, obj.getIdUser());
			if(ps.executeUpdate() == 1)
				System.out.println("Le compte client a bien été créé");
		} catch (SQLException e) {
			logger.severe("Problème de création du compte client : " + e.getMessage());
		}
	}

	@Override
	public Customer read(int id) {
		Customer customer = null;
		String readCustomer = "SELECT IdCustomer, Name, FirstName, Address, Email, Phone, IdUser FROM T_Customers WHERE IdCustomer = ?;";
		try(PreparedStatement ps = connection.prepareStatement(readCustomer)) {
			ps.setInt(1, id);
			try(ResultSet resultSet = ps.executeQuery()){
				if(resultSet.next()) {
					int rsIdCustomer = resultSet.getInt("IdCustomer");
					String rsName = resultSet.getString("Name");
					String rsFirstName = resultSet.getString("FirstName");
					String rsAddress = resultSet.getString("Address");
					String rsEmail = resultSet.getString("Email");
					String rsPhone = resultSet.getString("Phone");
					int rsIdUser = resultSet.getInt("IdUser");
					return customer = new Customer(rsIdCustomer, rsName, rsFirstName, rsAddress, rsEmail, rsPhone, rsIdUser);
				}else
					System.out.println("Compte client non trouvé");
			}
		} catch (SQLException e) {
			logger.severe("Problème de lecture du compte client : " + e.getMessage());
		}
		return customer;
	}

	@Override
	public boolean update(Customer obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Customer obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Customer> readAll() {
		String customersList = "SELECT * FROM T_Customers;";
		try(Statement st = connection.createStatement()) {
			try(ResultSet resultSet = st.executeQuery(customersList)){
				while(resultSet.next()) {
					int rsIdCustomer = resultSet.getInt("IdCustomer");
					String rsName = resultSet.getString("Name");
					String rsFirstName = resultSet.getString("FirstName");
					String rsAddress = resultSet.getString("Address");
					String rsEmail = resultSet.getString("Email");
					String rsPhone = resultSet.getString("Phone");
					int rsIdUser = resultSet.getInt("IdUser");
					customers.add(new Customer(rsIdCustomer, rsName, rsFirstName, rsAddress, rsEmail, rsPhone, rsIdUser));
				}
			}
		} catch (SQLException e) {
			logger.severe("Liste de client non trouvée : " + e.getMessage());
		}
		return customers;
	}
	
	public Customer findCustomer(int idUser) {
		String requestSql = "SELECT * FROM T_Customers WHERE IdCustomer = ?;";
		try(PreparedStatement ps = connection.prepareStatement(requestSql)) {
			ps.setInt(1, idUser);
			try(ResultSet resultSet = ps.executeQuery()){
				if(resultSet.next()) {
					int rsIdCustomer = resultSet.getInt("IdCustomer");
					String rsName = resultSet.getString("Name");
					String rsFirstName = resultSet.getString("FirstName");
					String rsAddress = resultSet.getString("Address");
					String rsEmail = resultSet.getString("Email");
					String rsPhone = resultSet.getString("Phone");
					int rsIdUser = resultSet.getInt("IdUser");
					System.out.println("Client trouvé");
					return new Customer(rsIdCustomer, rsName, rsFirstName, rsAddress, rsEmail, rsPhone, rsIdUser);
				}else
					System.out.println("Compte client non trouvé");
			}
		} catch (SQLException e) {
			logger.severe("Problème de lecture du compte client : " + e.getMessage());
		}
		return null;
	}

}
