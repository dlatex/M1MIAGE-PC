package fr.uga.m1;

public class LigneCommande {

	private Produit produit;
	private int quantite;

	public LigneCommande(Produit produit) {
		this.produit = produit;
		quantite = 1;
	}

	public int getQuantite() {
		return this.quantite;
	}

	public Produit getProduit() {
		return produit;
	}

	public void ajouteProduit() {
		this.quantite++;
	}

	public void enleverProduit() {
		if (this.quantite > 0) {
			quantite--;
		}
	}

	public void modifierProduit(int k) {
		if(this.quantite==0 && k<0) return ;
		this.quantite += k;
	}

	public String toString() {
		System.out.println(this.getDescription());
		System.out.println("--------------");
		return "\t" + getQuantite() + "\t" + produit.getNom();
	}

	public float totalLigne() {
		return produit.getPrix() * this.quantite;
	}

	public String getDescription() {
		StringBuffer description = new StringBuffer("Ligne de Commande: ");
		description.append(produit.getNom() + " ");
		description.append(" pour une valeur de: ");
		description.append(this.totalLigne()).append("\u20ac");
		return description.toString();
	}
}