package fr.fms.entities;

public class OrderItem {

	private int idOrderItem;
	private int quantity;
	private double amount;
	private int idTrainingCourse;
	private int idOrder;
	
	public OrderItem(int idOrderItem, int quantity, double amount, int idTrainingCourse, int idOrder) {
		super();
		this.idOrderItem = idOrderItem;
		this.quantity = quantity;
		this.amount = amount;
		this.idTrainingCourse = idTrainingCourse;
		this.idOrder = idOrder;
	}
	
	public OrderItem(int quantity, double amount, int idTrainingCourse) {
		super();
		this.quantity = quantity;
		this.amount = amount;
		this.idTrainingCourse = idTrainingCourse;
	}
	
	public int getIdOrderItem() {
		return idOrderItem;
	}
	
	public void setIdOrderItem(int idOrderItem) {
		this.idOrderItem = idOrderItem;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
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
		return "OrderItem [idOrderItem=" + idOrderItem + ", quantity=" + quantity + ", amount=" + amount
				+ ", idTrainingCourse=" + idTrainingCourse + ", idOrder=" + idOrder + "]";
	}
	
}
