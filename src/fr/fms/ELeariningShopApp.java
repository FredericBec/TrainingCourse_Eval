package fr.fms;

import java.util.ArrayList;
import java.util.Scanner;

import fr.fms.business.IBusiness;
import fr.fms.business.IBusinessImpl;
import fr.fms.entities.TrainingCourse;

public class ELeariningShopApp {

	private static Scanner scan = new Scanner(System.in);
	//private static ArrayList<String> menu = new ArrayList<String>();
	private static IBusiness business = new IBusinessImpl();
	
	public static void main(String[] args) {
		System.out.println("Bienvenue dans ma boutique, voici la liste des fomations disponibles\n");
		displayTrainingCourses();
		int choice = 0;
		while(choice != 6) {
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
				displayTrainingCourseByCategory();
				break;
			case 4 :
			case 5 :
				
			case 6 :
				System.exit(0);
				break;
			default :
				System.out.println("Veuillez saisir une valeur comprise entre 1 et 6");
			}
		}

	}
	
	public static void displayMenu() {
		ArrayList<String> menu = new ArrayList<String>();
		menu.add("Ajouter une formation");
		menu.add("retirer une formation");
		menu.add("rechercher une formation par categorie");
		menu.add("rechercher une formation");
		menu.add("afficher mon panier et passer une commande");
		menu.add("Sortir");
		
		int index = 1;
		for(String m : menu)
			System.out.println(index++ + " - " + m);
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
		if(tc != null) business.addToCart(tc);
		else System.out.println("La formation sélectionnée n'existe pas !!");
	}
	
	public static void removeTrainingCourse() {
		System.out.println("Sélectionner la formation à retirer");
		int id = getInt();
		business.deleteFromCart(id);
	}
	
	public static int getInt() {
		if(!scan.hasNext()) {
			System.out.println("Saississez ue valeur entière !!");
			scan.next();
		}
		
		return scan.nextInt();
	} 
	

}
