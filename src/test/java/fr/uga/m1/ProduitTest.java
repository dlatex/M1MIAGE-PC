package fr.uga.m1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ProduitTest extends AbstractTest {

	@Test
	public void testProduit() {
		Produit p = new Produit("Chaussures", "Chaussures de ville confortables", 2, 85.0F);
		System.out.println(p);
		assertEquals("Chaussures", p.getNom());
		assertEquals("Chaussures de ville confortables", p.getDescription());
		assertEquals(2, p.getQuantite());
		assertTrue(85.0F == p.getPrix());
	}

	public void testDeclaredConstructors() {
		assertDeclaredConstructor(fr.uga.m1.Produit.class, new Class[] { long.class, String.class, String.class },
				"missing constructor Produit(String, String, int,int) in class Produit");
	}

	private void testDeclaredMethods() {
		assertDeclaredMethod(fr.uga.m1.Produit.class, "getNom", new Class[] {},
				"missing method getNom() in class Produit");
		assertDeclaredMethod(fr.uga.m1.Produit.class, "getDescription", new Class[] {},
				"missing method getDescription() in class Produit");
		assertDeclaredMethod(fr.uga.m1.Produit.class, "getPrix", new Class[] {},
				"missing method getPrix() in class Produit");
		assertDeclaredMethod(fr.uga.m1.Produit.class, "getQuantite", new Class[] {},
				"missing method getQuantite() in class Produit");

	}
	public void testGetQuantite() {
		Produit p = new Produit("HP ENVY ","PC Portable",1,999.0F);

		int expected = 1;
		long value = p.getQuantite();
		assertEquals(expected, value);

		p = new Produit("HP ENVY ","PC Portable",5,999.0F);
		expected = 5;
		value = p.getQuantite();
		assertEquals(expected, value);
	}
	public void testGetNom() {
		Produit p = new Produit("Asus ROG ","PC Portable",1,899.0F);

		String expected = "Asus ROG";
		String value = p.getNom();
		assertEquals(expected, value);

		p = new Produit("Asus ROG G552 ","PC Portable",2,799.0F);
		expected = "Asus ROG G552";
		value = p.getNom();
		assertEquals(expected, value);
	}
	public void testGetDescription() {
		Produit p = new Produit("Asus ROG ","PC Gamer",1,899.0F);

		String expected = "PC Gamer";
		String value = p.getDescription();
		assertEquals(expected, value);
	}
	public void testGetPrix() {
		Produit asus = new Produit("Asus ROG ","PC Gamer",1,899.0F);
		Produit hp = new Produit("HP ENVY ","PC Portable",1,999.0F);
		float expected = 899.0F;
		float value =asus.getPrix();
		assertEquals(expected, value);

		expected=hp.getPrix();
		value=999.0F;
		assertEquals(expected, value);
	}

	protected void runTests() {
		this.testExpected = 12;
		try {
			testDeclaredMethods();			
		} catch (Exception e) {e.printStackTrace();}
		try {
			testDeclaredConstructors();			
		} catch (Exception e) {e.printStackTrace();}

		try {
		testGetPrix();
		} catch (Exception e) { e.printStackTrace(); }
		try {
		testGetDescription();
		} catch (Exception e) { e.printStackTrace(); }
		try {
		testGetQuantite();
		} catch (Exception e) { e.printStackTrace(); }
		try {
		testProduit();
		} catch (Exception e) { e.printStackTrace(); }
	}

}
