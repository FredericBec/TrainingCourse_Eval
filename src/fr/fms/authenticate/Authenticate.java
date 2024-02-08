package fr.fms.authenticate;

import fr.fms.dao.CustomerDao;
import fr.fms.dao.UserDao;
import fr.fms.entities.Customer;
import fr.fms.entities.User;

public class Authenticate {

	private static UserDao userDao = new UserDao();
	private static CustomerDao customerDao = new CustomerDao();
	
	public int validLogin(String login, String pwd) {
		User user = userDao.findUserByCredentials(login, pwd);
		if(user != null) return user.getIdUser();
		return 0;
	}
	
	public Customer existCustomer(int idUser) {
		return customerDao.findCustomer(idUser);
	}
	
	public void addUser(String login, String password) {
		userDao.create(new User(login, password));
	}
	
	public boolean addCustomer(Customer obj) {
		customerDao.create(obj);
		return true;
	}
}
