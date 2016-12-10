package fr.uga.m1;

import java.util.ArrayList;
import java.util.List;

import fr.uga.m1.compta.ServiceComptabilite;
import fr.uga.m1.stock.ServiceStock;

public class Panier {
	private List<LigneCommande> listeLigneCommande;
	EtatPanier etatPanier;
	EtatPreValide preCommande;
	EtatValide valide;
	EtatNonValide nonValide;

	private ServiceComptabilite compta = ServiceComptabilite.getServiceComptabilite();
	private ServiceStock stock = ServiceStock.getServiceStock();

	public Panier() {
		listeLigneCommande = new ArrayList<LigneCommande>();
		etatPanier = new EtatNonValide(this);
	}

	public float getPrixTotal() {
		float prix = 0.0F;
		for (LigneCommande l : listeLigneCommande) {
			prix += l.totalLigne();
		}
		return prix;
	}

	public boolean passerCommande() {
		return stock.traite(this) && compta.traite(this);
	}

	/*** Version partie 3 ***/
	public EtatPanier getEtat() {
		return etatPanier;
	}

	public void changeEtat(EtatPanier etat) {
		this.etatPanier = etat;
	}

	public void ajouterLigneCommande(Produit produit) {
		if (this.getEtat().toString().equals("Etat non valide")) {
			nonValide = new EtatNonValide(this);
			nonValide.ajouterLigneCommande(listeLigneCommande, produit);
		}
		if (this.getEtat().toString().equals("Etat PreCommande")) {
			preCommande = new EtatPreValide(this);
			preCommande.ajouterLigneCommande(listeLigneCommande, produit);
		}
		if (this.getEtat().toString().equals("Etat Valide")) {
			valide = new EtatValide(this);
			valide.ajouterLigneCommande(listeLigneCommande, produit);
		}
	}

	public void enleverLigneCommande(Produit produit) {
		if (this.getEtat().toString().equals("Etat non valide")) {
			nonValide = new EtatNonValide(this);
			nonValide.enleverLigneCommande(listeLigneCommande, produit);
		}
		if (this.getEtat().toString().equals("Etat PreCommande")) {
			preCommande = new EtatPreValide(this);
			preCommande.enleverLigneCommande(listeLigneCommande, produit);
		}
		if (this.getEtat().toString().equals("Etat Valide")) {
			valide = new EtatValide(this);
			valide.enleverLigneCommande(listeLigneCommande, produit);
		}
	}

	public void modifierLigneCommande(Produit produit, int quantite) {
		if (this.getEtat().toString().equals("Etat non valide")) {
			nonValide = new EtatNonValide(this);
			nonValide.modifierLigneCommande(listeLigneCommande, produit,quantite);
		}
		if (this.getEtat().toString().equals("Etat PreCommande")) {
			preCommande = new EtatPreValide(this);
			preCommande.modifierLigneCommande(listeLigneCommande, produit,quantite);
		}
		if (this.getEtat().toString().equals("Etat Valide")) {
			valide = new EtatValide(this);
			valide.modifierLigneCommande(listeLigneCommande, produit,quantite);
		}
	}

	public void setEtat(EtatPanier etat) {
		this.etatPanier = etat;
	}

	public String toString() {
		StringBuffer sB = new StringBuffer();
		String contenu = "\n-----Votre Panier contient:\n";
		
		sB.append(contenu);
		sB.append("Quantite\t"+"Produit"+"\t\tPrix unitaire\n");
		for (LigneCommande lc : listeLigneCommande) {
			if (lc.getQuantite() == 0) {
				sB.append("");
			} else {
				sB.append("" + lc.getQuantite()).append("\t\t").append(lc.getProduit().getNom())
						.append("\t\t").append(lc.getProduit().getPrix()).append("\u20ac"+"\n");
			}

		}
		sB.append("La valeur du panier est de: ").append(this.getPrixTotal()).append("\u20ac");
		return sB.toString();
	}
}