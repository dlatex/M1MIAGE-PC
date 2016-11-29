package fr.uga.m1;

public class LigneCommande {

	private Produit produit;

	public LigneCommande(Produit produit) {
		this.produit=produit;
	}

	public int getQuantite() {
		return produit.getQuantite();
	}


	public Produit getProduit() {
		return produit;
	}

	public void ajouteProduit() {
		this.produit.setQuantite(this.produit.getQuantite()+1);
	}

	public void modifierProduit(int quantite) {
		if (this.produit.getQuantite() < quantite) {
			throw new IllegalArgumentException("La Ligne de commande ne contient pas autant de produit");
		}
		if (produit.getQuantite() > 0) {
			this.produit.setQuantite(-quantite);
		}
	}
	public String toString(){
		System.out.println("--------------");
		return "\t"+getQuantite()+"\t"+produit.getNom();
	}
	public float totalLigne() {
		return produit.getPrix() * produit.getQuantite();
	}
	public String getDescription() {
		StringBuffer description = new StringBuffer("La ligne de commande contient:");
			description.append(produit.getNom()).append(" pour une valeur de: ");
		description.append(this.totalLigne()).append("€");
		return description.toString();
	}
}