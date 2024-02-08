package fr.fms.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Order;

public class OrderDao implements Dao<Order>{

	@Override
	public void create(Order obj) {
		String createOrder = "INSERT INTO T_Orders (Name, TotalAmount, DateOrder, IdCustomer) VALUES (?,?,?,?);";
		try(PreparedStatement ps = connection.prepareStatement(createOrder, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, obj.getName());
			ps.setDouble(2, obj.getTotalAmount());
			ps.setDate(3, new Date(obj.getDate().getTime()));
			ps.setInt(4, obj.getIdCustomer());
			if(ps.executeUpdate() == 1)
				System.out.println("La commande a bien été créée");
			try(ResultSet generetadKeySet = ps.getGeneratedKeys()){
				if(generetadKeySet.next())
					obj.setIdOrder(generetadKeySet.getInt(1));
			}
		} catch (SQLException e) {
			logger.severe("Problème de création de la commande : " + e.getMessage());
		}
		
	}

	@Override
	public Order read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Order obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Order obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Order> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
