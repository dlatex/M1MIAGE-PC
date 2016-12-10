package fr.uga.m1;

import java.util.List;

public class EtatValide extends EtatPanier {

	public EtatValide(Panier panier) {

	}

	public void enleverLigneCommande(List<LigneCommande> panier, Produit produit) {
		System.out.println("\tOperation de suppression impossible commande validee");
	}

	public void changeState(Panier panier) {
		panier.changeEtat(new EtatValide(panier));
	}

	public String toString() {
		return "Etat Valide";
	}

	@Override
	public void modifierLigneCommande(List<LigneCommande> commande, Produit produit, int q) {
		// TODO Auto-generated method stub
		System.out.println("\tOperation de modification impossible commande validee");
	}

	@Override
	public void ajouterLigneCommande(List<LigneCommande> commande, Produit produit) {
		// TODO Auto-generated method stub
		System.out.println("\tOperation d'ajout impossible commande validee");
	}
}
