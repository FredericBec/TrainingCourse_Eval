package fr.fms.entities;

public class OrderItem {

	private int idOrderItem;
	private double price;
	private int idTrainingCourse;
	private int idOrder;
	
	public OrderItem(int idOrderItem, double price, int idTrainingCourse, int idOrder) {
		super();
		this.idOrderItem = idOrderItem;
		this.price = price;
		this.idTrainingCourse = idTrainingCourse;
		this.idOrder = idOrder;
	}
	
	public OrderItem(double price, int idTrainingCourse, int idOrder) {
		this.price = price;
		this.idTrainingCourse = idTrainingCourse;
		this.idOrder = idOrder;
	}
	
	public int getIdOrderItem() {
		return idOrderItem;
	}
	
	public void setIdOrderItem(int idOrderItem) {
		this.idOrderItem = idOrderItem;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getIdTrainingCourse() {
		return idTrainingCourse;
	}
	
	public void setIdTrainingCourse(int idTrainingCourse) {
		this.idTrainingCourse = idTrainingCourse;
	}
	
	public int getIdOrder() {
		return idOrder;
	}
	
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	@Override
	public String toString() {
		return "OrderItem [idOrderItem=" + idOrderItem + ", price=" + price
				+ ", idTrainingCourse=" + idTrainingCourse + ", idOrder=" + idOrder + "]";
	}
	
}
