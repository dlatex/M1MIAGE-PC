package fr.uga.m1;

import java.util.ArrayList;
import java.util.List;

public class EtatPreCommande extends EtatPanier {

	private List<LigneCommande> ligneCommande;

	public EtatPreCommande() {
		ligneCommande = new ArrayList<LigneCommande>();
	}

	public void ajouteLigneCommande(Produit p) {
		if (ligneCommande.size() == 0) {
			LigneCommande produit = new LigneCommande(p);
			ligneCommande.add(produit);
		} else {
			for (LigneCommande lp : ligneCommande) {
				if (lp.getProduit().getNom().equals(p.getNom())) {
					lp.ajouteProduit();
				} else {
					LigneCommande produit = new LigneCommande(p);
					ligneCommande.add(produit);
				}
			}
		}
	}

	public void afficherLigneCommande() {
		for (LigneCommande p : ligneCommande) {
			System.out.println(p.getDescription());
		}
	}

	public void modifierLigneCommande(LigneCommande lc, int i) {
		for (LigneCommande commande : ligneCommande) {
			if (commande.getProduit().equals(lc.getProduit())) {
				commande.modifierProduit(i);
			}
		}
	}

	public void enleverLigneCommande(LigneCommande lc) {
		ligneCommande.remove(lc);
	}
	public String toString(){
		return "EtatPreCommande";
	}
	@Override
	public void ajouterLigneCommande(LigneCommande lc) {
		throw new IllegalArgumentException("La Ligne de commande ne contient pas autant de produit");
	}

	@Override
	public EtatPanier nextState(EtatPanier state) {
		return state;
	}
	
}
