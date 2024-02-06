package fr.fms.entities;

public class Category {

	private int IdCategory;
	private String CatName;
	private String Description;
	
	public Category(int idCategory, String catName, String description) {
		super();
		IdCategory = idCategory;
		CatName = catName;
		Description = description;
	}

	public int getIdCategory() {
		return IdCategory;
	}

	public void setIdCategory(int idCategory) {
		IdCategory = idCategory;
	}

	public String getCatName() {
		return CatName;
	}

	public void setCatName(String catName) {
		CatName = catName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		return IdCategory + " - " + CatName + " - " + Description;
	}
}
