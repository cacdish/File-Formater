package com.gmail.vpouhe.file.formater.model;

/**
 * Classe mod�lisant un articles
 * 
 * @author Vincent
 *
 */
public class Reference {
	private String numReference = "";// Le num�ro de r�f�rence de l'object
	private String color = "";// La Couleur de l'objet
	private String size = "";// La taille de l'objet
	private String price = "";// Le prix de l'objet

	public Reference() {
		super();
	}

	public Reference(String numReference, String color, String size, String price) {
		super();
		this.numReference = numReference;
		this.color = color;
		this.size = size;
		this.price = price;
	}

	public String getNumReference() {
		return numReference;
	}

	public void setNumReference(String numReference) {
		this.numReference = numReference;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Article [numReference=" + numReference + ", color=" + color + ", size=" + size + ", price=" + price
				+ "]";
	}

}
