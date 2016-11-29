package fr.uga.m1;

import java.util.Iterator;
import java.util.List;

public class ProduitIterator implements Iterator<Produit> {
	private List<Produit> produits;
	private int index;

	public ProduitIterator(List<Produit> listeProduit) {
		index = 0;
		this.produits = listeProduit;
	}

	public Produit next() {
		if (hasNext()) {
			Produit p = this.produits.get(index);
			index++;
			return p;
		}
		return null;
	}

	public boolean hasNext() {
		return index < this.produits.size();
	}
}