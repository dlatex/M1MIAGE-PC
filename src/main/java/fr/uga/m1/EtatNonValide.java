package fr.uga.m1;

import java.util.List;

public class EtatNonValide extends EtatPanier {
	Panier panierCommande;

	public EtatNonValide(Panier panier) {
		panierCommande = panier;
	}

	public void modifierLigneCommande(List<LigneCommande> panier, Produit produit, int q) {
		List<LigneCommande> commande = panier;
		for (LigneCommande ligne : commande) {
			if (ligne.getProduit().getNom().equals(produit.getNom())) {
				ligne.modifierProduit(q);
			}
		}

	}

	public void ajouterLigneCommande(List<LigneCommande> commande, Produit produit) {
		int flag = 0;
		if (produit == null)
			return;
		if (commande.size() == 0) {
			System.out.println("Out");
			commande.add((new LigneCommande(produit)));
			flag = 1;
		}
		if (commande.size() > 0 && flag == 0) {
			for (LigneCommande cmd : commande) {
				if (cmd.getProduit().getNom().equals(produit.getNom())) {
					cmd.modifierProduit(1);
					flag = 1;
				}
			}
		}
		if (flag == 0) {
			commande.add((new LigneCommande(produit)));
		}

	}

	public void enleverLigneCommande(List<LigneCommande> commande, Produit produit) {
		if (commande.size() == 0) {
			System.out.println('s');
		}
		if (commande.size() > 0) {
			for (LigneCommande cmd : commande) {
				if (cmd.getProduit().equals(produit)) {
					cmd.enleverProduit();
					commande.remove(produit);
				}
			}
		}

	}

	// ok
	public void changeState(Panier panier) {
		panier.changeEtat(new EtatPreValide(panier));
	}

	public String toString() {
		return "Etat non valide";
	}
}
