package fr.uga.m1;

import static org.junit.Assert.*;

import org.junit.Test;

public class PanierTest {

//	@Test
//	public void testPasserCommande() {
//		assertTrue(new Panier().passerCommande());
//	}

	@Test
	public void testPanier() {
		Produit p = new Produit("Chaussures", "Chaussures de ville confortables", 2, 85.0F);
		Produit pa = new Produit("Chaussures", "Chaussures de ville confortables", 1, 95.0F);
		
		Panier panier=new Panier();
		panier.ajouteProduit(p);
		panier.ajouteProduit(pa);
		
		System.out.println(panier.getPrixTotal());
		System.out.println(panier.toString());
		
		assertEquals("Chaussures", p.getNom());
		assertEquals("Chaussures de ville confortables", p.getDescription());
		assertEquals(2, p.getQuantite());
		assertTrue(265.0F==panier.getPrixTotal());
		
		panier.enleveProduit(pa);
		System.out.println(panier.toString());
	}
	

}
