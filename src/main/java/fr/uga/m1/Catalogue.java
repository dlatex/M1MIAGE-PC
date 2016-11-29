package fr.uga.m1;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {
	private List<Univers> catalogue;

	public Catalogue(Univers univers) {
		catalogue = new ArrayList<Univers>();
		catalogue.add(univers);
	}

	public void ajouteUnivers(Univers univers) {
		if(univers==null) return;
		catalogue.add(univers);
	}
	public void enleveUnivers(Univers univers) {
		catalogue.remove(univers);
	}

	public void afficherListeUniversCatalogue() {
		UniversIteratorImpl piT = new UniversIteratorImpl();
		while (piT.hasNext()) {
			System.out.println(piT.next());
		}
	}
	public List<Univers> getCatalogue() {
		return catalogue;
	}
}