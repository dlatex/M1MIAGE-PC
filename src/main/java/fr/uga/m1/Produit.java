package fr.uga.m1;

import java.text.NumberFormat;

public class Produit {

	private String nom;
	private String description;
	private int quantite;
	private float prix;

	public Produit(String nom, String description, int quantite, float prix) {
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;
		this.description = description;
	}

	public String getNom() {
		return nom;
	}	

	public String getDescription() {
		return description;
	}

	public int getQuantite() {
		return quantite;
	}

	public float getPrix() {
		return prix;
	}

	public String toString() {

		NumberFormat fmt = NumberFormat.getCurrencyInstance();

		return (getNom() + "\t" + fmt.format(getPrix()) + "\t" + getQuantite() + "\t\t"
				+ fmt.format(getPrix() * getQuantite()));
	}

}