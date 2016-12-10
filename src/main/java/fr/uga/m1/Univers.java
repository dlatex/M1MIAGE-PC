package fr.uga.m1;

import java.util.ArrayList;
import java.util.List;

public class Univers {
	List<Produit> univers;
	private String nom;

	public Univers(String nom) {
		univers = new ArrayList<Produit>();
		this.nom = nom;
	}

	public void ajouteProduit(Produit p) {
		if(p==null)
			return;
		univers.add(p);
	}

	public void enleveProduit(Produit p) {
		univers.remove(p);
	}

	public String getNom() {
		return nom;
	}

	public int nombreProduit() {
		return univers.size();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("-----"+getNom()).append(" & contient " + nombreProduit()+" produit(s)");
		ProduitIterator piT = new ProduitIterator(univers);
		while (piT.hasNext()) {
			Produit p=piT.next();
			sb.append(p.toString());
		}
		sb.append("\n\n");
		return sb.toString();
	}

	public void afficherListeProduitUnivers() {
		ProduitIterator piT = new ProduitIterator(univers);
		while (piT.hasNext()) {
			System.out.println(piT.next());
		}
	}

	public List<Produit> getListProduit() {
		// TODO Auto-generated method stub
		return univers;
	}
}