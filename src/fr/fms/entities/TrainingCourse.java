package fr.fms.entities;

public class TrainingCourse {

	private int IdTrainingCourse;
	private String name;
	private String description;
	private int duration;
	private double price;
	private int IdCategory;
	
	public TrainingCourse(int IdTrainingCourse, String name, String description, int duration, double price) {
		this.IdTrainingCourse = IdTrainingCourse;
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.price = price;
	}
	
	public TrainingCourse(int IdTrainingCourse, String name, String description, int duration, double price, int IdCategory) {
		this.IdTrainingCourse = IdTrainingCourse;
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.price = price;
		this.IdCategory = IdCategory;
	}

	public int getIdTrainingCourse() {
		return IdTrainingCourse;
	}

	public void setIdTrainingCourse(int idTrainingCourse) {
		IdTrainingCourse = idTrainingCourse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getIdCategory() {
		return IdCategory;
	}

	public void setIdCategory(int idCategory) {
		IdCategory = idCategory;
	}

	@Override
	public String toString() {
		return IdTrainingCourse + " - " + name + " - "
				+ description + " - " + duration + " - " + price;
	}
}
