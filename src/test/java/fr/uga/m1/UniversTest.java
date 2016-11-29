package fr.uga.m1;

import org.junit.Test;

public class UniversTest extends AbstractTest{
	@Test
	public void universtest() {
universMain();
	}
	private void universMain(){
			System.out.println("");
		Univers u = new Univers("Maison");
		Produit p = new Produit("Chaussures", "Chaussures de ville confortables", 2, 85.0F);
		Produit pr = new Produit("Nike", "Chaussures de ville", 6, 50.0F);
		u.ajouteProduit(pr);
		u.ajouteProduit(p);
		u.afficherListeProduitUnivers();	
	}
	private void testDeclaredMethods() {
		assertDeclaredMethod(fr.uga.m1.Univers.class, "getNom", new Class[] {},
				"missing method getNom() in class Univers");
		assertDeclaredMethod(fr.uga.m1.Univers.class, "nombreProduit", new Class[] {},
				"missing method nombreProduit() in class Univers");
		assertDeclaredMethod(fr.uga.m1.Univers.class, "afficherListeProduitUnivers", new Class[] {},
				"missing method afficherListeProduitUnivers() in class Univers");
		assertDeclaredMethod(fr.uga.m1.Univers.class, "ajouteProduit", new Class[] {Produit.class},
				"missing method ajouteProduit() in class Univers");
		assertDeclaredMethod(fr.uga.m1.Univers.class, "enleveProduit", new Class[] {Produit.class},
				"missing method enleveProduit() in class Univers");

	}
	public void testDeclaredConstructors() {
		assertDeclaredConstructor(fr.uga.m1.Univers.class, new Class[] {String.class},
				"missing constructor Univers(String) in class Univers");
	}

	public void testajouteProduitEtNombreProduit() {

		Univers univers = new Univers("Informatique");

		Produit asus = new Produit("Asus ROG","PC Gamer",1,899.0F);
		Produit hp = new Produit("HP ENVY","PC Portable",1,999.0F);
		Produit mac = new Produit("MacBook Air","PC Portable",1,1299.0F);

		assertEquals(0, univers.nombreProduit());
		univers.ajouteProduit(hp);
		assertEquals(1, univers.nombreProduit());
				
		univers.ajouteProduit(asus);
		assertEquals(2, univers.nombreProduit());
		univers.ajouteProduit(mac);
		assertEquals(3, univers.nombreProduit());		
				
		univers.ajouteProduit(null);
		assertEquals(3, univers.nombreProduit());				
	}

	public void testEnleveProduitEtNombreProduit() {

		Univers univers = new Univers("High-Tech");

		Produit beats=new Produit("Beats","Casque audio",1,399.0F);
		univers.enleveProduit(null);

		assertEquals(0, univers.nombreProduit());				

		univers.ajouteProduit(beats);
		univers.enleveProduit(beats);
		assertEquals(0, univers.nombreProduit());	

		Produit goPro=new Produit("Go Pro","camera Sportif",1,299.0F);
		Produit galaxy=new Produit("Galaxy"," Mobile",1,699.0F);
		Produit iPhone=new Produit("Iphone X","Mobile",1,699.0F);

		univers.ajouteProduit(goPro);
		univers.ajouteProduit(galaxy);
		univers.ajouteProduit(iPhone);
		univers.enleveProduit(null);
		assertEquals(3, univers.nombreProduit());				
		
		univers.enleveProduit(galaxy);
		assertEquals(2, univers.nombreProduit());		
	}

	public void testGetNom() {
		Univers univers = new Univers("High-Tech");
		String expected = "High-Tech";
		String value = univers.getNom();
		assertEquals(expected, value);
	}

		public void testAfficherListeProduitUnivers() {
		Univers  univers=new Univers("HT-INFO");
		Produit goPro=new Produit("Go Pro","camera Sportif",1,299.0F);
		Produit asus = new Produit("Asus ROG","PC Gamer",1,899.0F);
		Produit hp = new Produit("HP ENVY","PC Portable",1,999.0F);
		Produit mac = new Produit("MacBook Air","PC Portable",1,1299.0F);

		univers.ajouteProduit(mac);
		univers.ajouteProduit(asus);
		univers.ajouteProduit(hp);
		univers.ajouteProduit(goPro);

		String goP = "Go Pro";
		String as="Asus ROG";
		String h="HP ENVY";
		String apple="MacBook Air";


	}
		
		protected void runTests() {
		this.testExpected = 16;
		try {
			testDeclaredMethods();			
		} catch (Exception e) {e.printStackTrace();}
		try {
			testDeclaredConstructors();			
		} catch (Exception e) {e.printStackTrace();}

		try {
		testAfficherListeProduitUnivers();
		} catch (Exception e) { e.printStackTrace(); }
		try {
		testEnleveProduitEtNombreProduit();
		} catch (Exception e) { e.printStackTrace(); }
		try {
		testajouteProduitEtNombreProduit();
		} catch (Exception e) { e.printStackTrace(); }
		try {
		testGetNom();
		} catch (Exception e) { e.printStackTrace(); }			
	}
}
