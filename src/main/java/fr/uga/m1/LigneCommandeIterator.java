package fr.uga.m1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LigneCommandeIterator implements Iterator<Produit>{
	private List<Produit> univers;
	private int index;

	public LigneCommandeIterator() {
		index = 0;
		univers = new ArrayList<Produit>();
	}

	@Override
	public boolean hasNext() {
		return index < univers.size();

	}

	@Override
	public Produit next() {
		if (hasNext()) {
			Produit p = univers.get(index);
			index++;
			return p;
		}
	
		return null;
	}

}
