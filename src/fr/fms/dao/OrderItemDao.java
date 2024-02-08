package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.OrderItem;

public class OrderItemDao implements Dao<OrderItem>{

	@Override
	public void create(OrderItem obj) {
		String createOrderItem = "INSERT INTO T_OrderItems (Price, IdTrainingCourse, IdOrder) VALUES (?,?,?)";
		try(PreparedStatement ps = connection.prepareStatement(createOrderItem)) {
			ps.setDouble(1, obj.getPrice());
			ps.setInt(2, obj.getIdTrainingCourse());
			ps.setInt(3, obj.getIdOrder());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.severe("Problème de création de la formation commandée : " + e.getMessage());
		}
	}

	@Override
	public OrderItem read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(OrderItem obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(OrderItem obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<OrderItem> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
