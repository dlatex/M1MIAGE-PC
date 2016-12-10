package fr.uga.m1;

import java.util.List;

public class EtatPreValide extends EtatPanier {
	Panier panierCommande;

	public EtatPreValide(Panier panier) {
		panierCommande = panier;
	}

	public void modifierLigneCommande(List<LigneCommande> panier, Produit produit,int q) {
		if (panier.size() == 0) {
			panier.add((new LigneCommande(produit)));
			System.out.println("je passe");
		}
		if (panier.size() > 0) {
			for (LigneCommande commande : panier) {			
				if (commande.getProduit().getNom().equals(produit.getNom())) {
					commande.modifierProduit(q);
				}
			}
		}


	}

	public void enleverLigneCommande(List<LigneCommande> panier, Produit produit) {
		int flag = 0;
		for (LigneCommande commande : panier) {
			if (commande.getProduit().getNom().equals(produit.getNom())) {
				commande.enleverProduit();
				flag = 1;
			}
		}
		if (flag == 0) {
			System.err.println("ce produit ne fait pas parti du panier");
		}
	}

	public String toString() {
		return "Etat PreCommande";
	}

	public void ajouterLigneCommande(List<LigneCommande> commande, Produit produit) {
		System.err.println("\nOperation ajout ligne de commande impossible dans l'etat pre-valide du panier\n");
	}

	public void changeState(Panier panier) {
		panier.changeEtat(new EtatValide(panier));
	}

}
