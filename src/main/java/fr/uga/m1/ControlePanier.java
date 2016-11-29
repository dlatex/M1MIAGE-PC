package fr.uga.m1;

public interface ControlePanier {
	public void modifierLigneCommande(LigneCommande lc,int quantite);

	public void ajouterLigneCommande(LigneCommande lc);

	public void enleverLigneCommande(LigneCommande lc);

	public EtatPanier nextState(EtatPanier state);
}
