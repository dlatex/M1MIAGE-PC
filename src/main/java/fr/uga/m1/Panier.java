package fr.uga.m1;

import java.util.ArrayList;
import java.util.List;

import fr.uga.m1.compta.ServiceComptabilite;
import fr.uga.m1.stock.ServiceStock;

public class Panier {
	/***
	 * A la creation du panier l'etat est nonValide la valeur est à -1 jusqu'a
	 * eventuel changement
	 */

	private List<Produit> produits;
	private List<LigneCommande> lPaniers;

	private ServiceComptabilite compta = ServiceComptabilite.getServiceComptabilite();
	private ServiceStock stock = ServiceStock.getServiceStock();
	EtatPanier etatPanier;

	public Panier() {
		produits = new ArrayList<Produit>();
		setlPaniers(new ArrayList<LigneCommande>());
		etatPanier = new EtatPreCommande();
	}

	public void ajouteProduit(Produit p) {
		if (p == null)
			return;
		produits.add(p);
	}

	public void enleveProduit(Produit p) {
		produits.remove(p);
	}

	public float getPrixTotal() {
		float prix = 0.0F;
		ProduitIterator produit = new ProduitIterator(produits);
		while (produit.hasNext()) {
			Produit p = produit.next();
			prix += p.getPrix() * p.getQuantite();
		}
		return prix;
	}

	public boolean passerCommande() {
		return stock.traite(this) && compta.traite(this);
	}

	public String toString() {
		StringBuffer sB = new StringBuffer();
		String contenu = "\nVotre Panier contient :\n";
		sB.append(contenu);
		for (Produit p : produits) {
			sB.append(p.getQuantite()).append(" ").append(p.getNom()).append(" au prix unitaire de ")
					.append(p.getPrix()).append("\n");
		}
		sB.append("\nLa valeur du panier est de: ").append(this.getPrixTotal()).append("€");
		sB.append("\nEtat du panier: ").append(this.getEtat().toString());
		return sB.toString();
	}



	public EtatPanier getEtat() {
		return etatPanier;
	}

	public List<LigneCommande> getlPaniers() {
		return lPaniers;
	}

	public void setlPaniers(List<LigneCommande> lPaniers) {
		this.lPaniers = lPaniers;
	}



}