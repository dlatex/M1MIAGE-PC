package fr.uga.m1;

import java.util.List;

public interface ControlePanier {
	public void modifierLigneCommande(List<LigneCommande> commande,Produit produit,int quantite);

	public void ajouterLigneCommande(List<LigneCommande> commande, Produit produit);

	public void enleverLigneCommande(List<LigneCommande>  commande,Produit produit);

	public void changeState(Panier panier);
}
