package fr.fms;

import java.util.ArrayList;
import java.util.Scanner;

import fr.fms.authenticate.Authenticate;
import fr.fms.business.IBusiness;
import fr.fms.business.IBusinessImpl;
import fr.fms.dao.UserDao;
import fr.fms.entities.Customer;
import fr.fms.entities.TrainingCourse;

public class ELeariningShopApp {

	private static Scanner scan = new Scanner(System.in);
	//private static ArrayList<String> menu = new ArrayList<String>();
	private static IBusiness business = new IBusinessImpl();
	private static Authenticate authenticate = new Authenticate();
	private static int idUser = 0;
	private static String login = null;
	
	
	public static void main(String[] args) {
		System.out.println("Bienvenue dans ma boutique, voici la liste des fomations disponibles\n");
		displayTrainingCourses();
		int choice = 0;
		while(choice != 8) {
			displayMenu();
			System.out.println("Que souhaitez vous faire ?");
			choice = getInt();
			switch(choice) {
			case 1 :
				addTrainingCourse();
				break;
			case 2 :
				removeTrainingCourse();
				break;
			case 3 :
				displayTrainingCourses();
				break;
			case 4 :
				displayTrainingCourseByCategory();
				break;
			case 5 :
				break;
			case 6 :
				order();
				break;
			case 7 :
				userConnection();
				break;
			case 8 :
				System.exit(0);
				break;
			default :
				System.out.println("Veuillez saisir une valeur comprise entre 1 et 6");
			}
		}

	}
	
	public static void displayMenu() {
		System.out.println("tapez le code correspondant pour effectuer votre choix");
		System.out.println("1 : Ajouter une formation");
		System.out.println("2 : retirer une formation");
		System.out.println("3 : Afficher les formations disponibles");
		System.out.println("4 : rechercher les formations par categorie");
		System.out.println("5 : rechercher les formation par mot clé");
		System.out.println("6 : afficher mon panier et passer une commande");
		System.out.println("7 : se connecter/déconnecter");
		System.out.println("8 : Sortir");
	}
	
	public static void displayTrainingCourses() {
		System.out.println("+----------------- Liste des formations -----------------+");
		business.readTrainingCourseList().stream().forEach(System.out::println);
		System.out.println("+--------------------------------------------------------+");
	}
	
	public static void displayCategories() {
		System.out.println("+----------------- Liste des catégories -----------------+");
		business.readCategories().stream().forEach(System.out::println);
		System.out.println("+--------------------------------------------------------+");
	}
	
	public static void displayTrainingCourseByCategory() {
		System.out.println("Voici la liste des catégories");
		displayCategories();
		System.out.println("Sélectionner la catégorie des formations à afficher");
		int id = getInt();
		System.out.println("Voici les formations " + business.readCategories().get(id - 1).getCatName());
		business.readTrainingCourseListByCategory(id).stream().forEach(System.out::println);
		System.out.println("+--------------------------------------------------------+");
	}
	
	public static void addTrainingCourse() {
		System.out.println("Sélectionner la formation à ajouter");
		int id = getInt();
		TrainingCourse tc = business.readTrainingCourse(id);
		boolean alreadyInCart = business.showCart().stream()
				.anyMatch(trainingCourse -> trainingCourse.getIdTrainingCourse() == tc.getIdTrainingCourse());
		if(!alreadyInCart) {
			if(tc != null) {
				business.addToCart(tc);
				
			} else {
				System.out.println("La formation sélectionnée n'existe pas !!");
			}
			
		}else {
			System.out.println("Une formation identique ne peut être ajouté");
		}
	}
	
	public static void removeTrainingCourse() {
		System.out.println("Sélectionner la formation à retirer");
		int id = getInt();
		business.deleteFromCart(id);
	}
	
	public static void order() {
		System.out.println("Voici votre panier :");
		business.showCart().stream().forEach(System.out::println);;
		System.out.println("Souhaitez-vous passer commande(oui/non) :");
		scan.nextLine();
		String response = scan.next();
		if(response.equalsIgnoreCase("oui")) {
			System.out.println("Montant de la commande : " + ((IBusinessImpl) business).getTotalAmount());
			if(login == null) {
				System.out.println("Pour poursuivre votre commande, veuillez vous connecter.");
				userConnection();
			}
			if(login != null){
				int idCustomer = addCustomer(idUser);
				if(idCustomer != 0) {
					int idOrder = business.takeOrder(idCustomer);
					if(idOrder == 0) System.out.println("Problème lors du passage de la commande");
					else {
						System.out.println("Votre a bien été prise en compte\n voici son numéro : " + idOrder);
						((IBusinessImpl) business).clearCart();
					}
				}
			}
			
		}
	}
	
	private static void userConnection() {
		if(login != null) {
			System.out.println("Souhaitez-vous vous déconnecter(oui/non) :");
			String response = scan.next();
			if(response.equalsIgnoreCase("oui")) {
				System.out.println("Au revoir " + login);
				login = null;
				idUser = 0;
			}
		}else {
			System.out.println("Veuillez saisir votre login :");
			String log = scan.next();
			System.out.println("Veuillez saisir votre mot de passe :");
			String pwd = scan.next();
			scan.nextLine();
			int id = authenticate.validLogin(log, pwd);
			if(id > 0) {
				login = log;
				idUser = id;
			}else {
				System.out.println("mot de passe ou login incorrect !");
				System.out.println("Souhaitez-vous créer un compte ?");
				String response = scan.nextLine();
				if(response.equalsIgnoreCase("oui")) {
					addUser();
				}
			}
		}
	}
	
	private static int addCustomer(int idUser) {
		Customer customer = authenticate.existCustomer(idUser);
		if(customer == null) {
			System.out.println("Saisissez votre nom :");
			String name = scan.next();
			System.out.println("Saisissez votre prénom :");
			String firstName = scan.next();
			System.out.println("Saisissez votre adresse :");
			String address = scan.next();
			System.out.println("Saisissez votre e-mail :");
			String email = scan.next();
			System.out.println("Saisissez votre téléphone :");
			String phone = scan.next();
			
			customer = new Customer(name, firstName, address, email, phone, idUser);
			if(authenticate.addCustomer(customer))
				return customer.getIdCustomer();
		}else {
			System.out.println("Nous allons associé votre commande avec le compte client : " + customer);
			return customer.getIdCustomer();
		}
		return 0;
		
	}
	
	private static void addUser() {
		System.out.println("Veuillez saisir un login :");
		String log = scan.next();
		System.out.println("Veuillez saisir un mot de passe :");
		String pwd = scan.next();
		
		int id = authenticate.validLogin(log, pwd);
		if(id == 0) {
			authenticate.addUser(log, pwd);
			System.out.println("Veuillez conserver vos informations...");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Utilisateur créé, vous pouvez vous connecter");
		}else
			System.out.println("Utilisateur déjà existant, veuillez saisir un autre login.");
	}
	
	public static int getInt() {
		if(!scan.hasNextInt()) {
			System.out.println("Saississez une valeur entière !!");
			scan.next();
		}
		
		return scan.nextInt();
	} 
	

}
