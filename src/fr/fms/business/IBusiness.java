package fr.fms.business;

import java.util.ArrayList;

import fr.fms.entities.Category;
import fr.fms.entities.TrainingCourse;

public interface IBusiness {

	/**
	 * Méthode pour ajouter une formation au panier
	 * @param obj
	 */
	public void addToCart(TrainingCourse obj);
	
	/**
	 * Méhotde permettant d'afficher le panier. 
	 */
	public ArrayList<TrainingCourse> showCart();
	
	/**
	 * Supprime une formation du panier
	 * @param id de la formation
	 */
	public void deleteFromCart(int id);
	
	/**
	 * Prise de commande en récupérant l'id du client en base
	 * @param id du compte client
	 * @return la commande
	 */
	public int takeOrder(int idCustomer);
	
	/**
	 * Méthode qui renvoie la liste des formations de la table t_trainingcourses en base
	 * @return liste des formations
	 */
	public ArrayList<TrainingCourse> readTrainingCourseList();
	
	/**
	 * Méthode qui renvoie une formation depuis la table t_trainingcourses en base
	 * @param id de la formation à retrouver
	 * @return la formation
	 */
	public TrainingCourse readTrainingCourse(int id);
	
	/**
	 * Méthode renvoyant les formations en fonction de la catégorie de puis la table t_trainingcourse
	 * en jointure la table t_categories
	 * @param id de la catégorie
	 * @return liste des formations filtrée.
	 */
	public ArrayList<TrainingCourse> readTrainingCourseListByCategory(int id);
	
	/**
	 * Méthode qui renvoie la liste des catégories depuis t_categories en base
	 * @return liste des catégories
	 */
	public ArrayList<Category> readCategories();
	
}
