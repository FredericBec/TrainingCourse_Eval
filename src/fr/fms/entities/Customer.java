package fr.fms.entities;

public class Customer {

	private int idCustomer;
	private String name;
	private String firstName;
	private String address;
	private String email;
	private String phone;
	private int idUser;
	
	public Customer(int idCustomer, String name, String firstName, String address, String email, String phone,
			int idUser) {
		this.idCustomer = idCustomer;
		this.name = name;
		this.firstName = firstName;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.idUser = idUser;
	}

	public Customer(String name, String firstName, String address, String email, String phone, int idUser) {
		this.name = name;
		this.firstName = firstName;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.idUser = idUser;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return idCustomer + " - " + name + " - " + firstName + " - "
				+ address + " - " + email + " - " + phone + " - " + idUser;
	}
	
}
