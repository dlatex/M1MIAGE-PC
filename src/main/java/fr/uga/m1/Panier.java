package fr.uga.m1;

import java.util.ArrayList;
import java.util.List;

import fr.uga.m1.compta.ServiceComptabilite;
import fr.uga.m1.stock.ServiceStock;

public class Panier {

	private List<Produit> produits;

	private ServiceComptabilite compta = ServiceComptabilite.getServiceComptabilite();
	private ServiceStock stock = ServiceStock.getServiceStock();

	public Panier() {
		produits = new ArrayList<Produit>();
	}

	public void ajouteProduit(Produit p) {
		produits.add(p);
	}

	public void enleveProduit(Produit p) {
		for (int i = 0; i < produits.size(); i++) {
			if (p.getNom().equals(produits.get(i).getNom()) && p.getPrix() == produits.get(i).getPrix()) {
				produits.remove(i);
			}
		}
	}

	public float getPrixTotal() {
		float pT = 0.0F;
		for (Produit p : produits) {
			pT += p.getPrix() * p.getQuantite();
		}
		return pT;
	}

	public boolean passerCommande() {
		return stock.traite(this) && compta.traite(this);
	}

	public String toString() {
		// TODO Afficher le contenu du panier
		StringBuffer str = new StringBuffer();
		String contenu = "\nVotre Panier contient :\n";
		str.append(contenu);
		for (Produit p : produits) {
			str.append(p.getQuantite()).append(" ").append(p.getNom()).append(" au prix unitaire de ")
					.append(p.getPrix()).append("\n");
		}
		str.append(" La valeur du panier est de: ").append(this.getPrixTotal());
		return str.toString();
	}

}