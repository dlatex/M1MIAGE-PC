package fr.uga.m1;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {
	private List<Univers> catalogue;
	private String nomCatalogue;

	public String getNomCatalogue() {
		return nomCatalogue;
	}

	public Catalogue(String nom) {
		catalogue = new ArrayList<Univers>();
		this.nomCatalogue = nom;
	}

	public void ajouteUnivers(Univers univers) {
		if (univers == null)
			return;
		catalogue.add(univers);
	}

	public void enleveUnivers(Univers univers) {
		catalogue.remove(univers);
	}


	public String toString() {
		StringBuilder sb = new StringBuilder("Bienvenue dans le catalogue " + this.nomCatalogue);
		if (catalogue.size() > 0) {
			sb.append("\n---Nous avons " + catalogue.size() + " univers a votre disposition");
			sb.append("\n------Les univers suivants sont a votre dispositions :\n");
		} else {
			sb.append("\n\tDesole notre catalogue est vide pour le moment");
		}
		
		UniversIteratorImpl piT = new UniversIteratorImpl(catalogue);
		while (piT.hasNext()) {
			Univers u = piT.next();
			sb.append(u.toString());
		}
		sb.append("\n");
		return sb.toString();
	}

	public List<Univers> getCatalogue() {
		// TODO Auto-generated method stub
		return catalogue;
	}
}