package fr.uga.m1;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProduitTest {

	@Test
	public void testProduit() {
		Produit p = new Produit("Chaussures", "Chaussures de ville confortables", 2, 85.0F);
		System.out.println(p);
		assertEquals("Chaussures", p.getNom());
		assertEquals("Chaussures de ville confortables", p.getDescription());
		assertEquals(2, p.getQuantite());
		assertTrue(85.0F == p.getPrix());
	}

}
