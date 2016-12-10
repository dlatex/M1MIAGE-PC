package fr.uga.m1;

import static org.junit.Assert.*;

import org.junit.Test;

public class PanierTest extends AbstractTest {

	@Test
	public void testPasserCommande() {
		System.out.println("");
		testPanier();
		//testLignePanier();
		System.out.println("");
		// System.out.println("----Test Passer Commande");
		//assertTrue((boolean) new Panier().passerCommande());
	}

	private void testPanier() {
		System.out.println("----------Test Panier----------------");
		Produit p = new Produit("Chaussures", "Chaussures de ville confortables", 2, 85.0F);
		Produit pa = new Produit("Chaussures", "Chaussures de sport", 1, 95.0F);

		Panier panier = new Panier();
		//panier.ajouteProduit(p);
		//panier.ajouteProduit(pa);

		System.out.println("Montant du panier: " + panier.getPrixTotal());
		System.out.println(panier.toString());

		assertEquals("Chaussures", p.getNom());
		assertEquals("Chaussures de ville confortables", p.getDescription());
		assertEquals(2, p.getQuantite());
		assertTrue(265.0F == panier.getPrixTotal());
		//panier.enleveProduit(pa);
		assertTrue(170.0F == panier.getPrixTotal());

		System.out.println(panier.toString());
	}
	// @Test
	// public void testPasserCommande() {
	// Panier panier = new Panier();
	// Produit p = new Produit("Chaussures", "Chaussures de ville confortables",
	// 2, 85.0F);
	// Produit nike = new Produit("Nike", "Chaussures de ville confortables", 2,
	// 85.0F);
	// panier.ajouteProduit(p);
	// panier.ajouteProduit(nike);
	// System.out.println(panier.getPrixTotal());
	// assertTrue(panier.passerCommande());
	// }
/*
	public void testLignePanier() {
		System.out.println("\n");
		System.out.println("----------Test fonction Ligne Panier----------------");
		Panier pl = new Panier();
		Produit produit = new Produit("Adidas", "Description", 3, 25.0F);
		pl.ajouteLigneCommande(produit);
		pl.toString();
		pl.afficherLigneCommande();
		System.out.println("\n");
	}
*/
	public void testDeclaredConstructors() {
		assertDeclaredConstructor(fr.uga.m1.Panier.class, new Class[] {},
				"missing constructor Panier() in class Panier");
	}

	private void testDeclaredMethods() {
		assertDeclaredMethod(fr.uga.m1.Panier.class, "ajouteProduit", new Class[] { Produit.class },
				"missing method ajouteProduit() in class Panier");
		assertDeclaredMethod(fr.uga.m1.Panier.class, "getPrixTotal", new Class[] {},
				"missing method getPrixTotal() in class Panier");
		assertDeclaredMethod(fr.uga.m1.Panier.class, "passerCommande", new Class[] {},
				"missing method passerCommande() in class Panier");
		assertDeclaredMethod(fr.uga.m1.Panier.class, "enleveProduit", new Class[] { Produit.class },
				"missing method enleveProduit() in class Panier");

	}

	protected void runTests() {
		this.testExpected = 5;
		try {
			testDeclaredMethods();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			testDeclaredConstructors();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
