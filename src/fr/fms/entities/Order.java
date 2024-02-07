package fr.fms.entities;

import java.util.Date;

public class Order {

	private int idOrder;
	private String name;
	private double totalAmount;
	private Date date;
	private int idCustomer;
	
	public Order(int idOrder, String name, double totalAmount, Date date, int idCustomer) {
		this.idOrder = idOrder;
		this.name = name;
		this.totalAmount = totalAmount;
		this.date = date;
		this.idCustomer = idCustomer;
	}
	
	public Order(String name, double totalAmount, Date date, int idCustomer) {
		this.name = name;
		this.totalAmount = totalAmount;
		this.date = date;
		this.idCustomer = idCustomer;
	}

	public Order(String name, double totalAmount, Date date) {
		this.name = name;
		this.totalAmount = totalAmount;
		this.date = date;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	@Override
	public String toString() {
		return "Order [idOrder=" + idOrder + ", name=" + name + ", totalAmount=" + totalAmount + ", date=" + date
				+ ", idCustomer=" + idCustomer + "]";
	}
}
