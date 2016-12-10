package fr.uga.m1;

import org.junit.Test;

public class CatalogueTest extends AbstractTest{
		@Test
	public void catalogueTest(){
catalogueTestAndAddRemoveUnivers();
	}

	private void catalogueTestAndAddRemoveUnivers(){
		Univers univers=new Univers("Maison");
		Univers hight=new Univers("High-Tech");

		Produit asus = new Produit("Asus ROG","PC Gamer",1,899.0F);
		Produit hp = new Produit("HP ENVY","PC Portable",1,999.0F);
		Produit mac = new Produit("MacBook Air","PC Portable",1,1299.0F);

		univers.ajouteProduit(asus);
		univers.ajouteProduit(hp);
		univers.ajouteProduit(mac);

		hight.ajouteProduit(new Produit("Adidas","Sport",1,12.3F));
	}
	public void testDeclaredConstructors() {
		assertDeclaredConstructor(fr.uga.m1.Catalogue.class, new Class[] { Univers.class},
				"missing constructor Catalogue(Univers) in class Catalogue");
	}

	private void testDeclaredMethods() {
		assertDeclaredMethod(fr.uga.m1.Catalogue.class, "ajouteUnivers", new Class[] {Univers.class},
				"missing method ajouteUnivers() in class Catalogue");
		assertDeclaredMethod(fr.uga.m1.Catalogue.class, "enleveUnivers", new Class[] {Univers.class},
				"missing method enleveUnivers() in class Catalogue");
		assertDeclaredMethod(fr.uga.m1.Catalogue.class, "afficherListeUniversCatalogue", new Class[] {},
				"missing method afficherListeUniversCatalogue() in class Catalogue");
		assertDeclaredMethod(fr.uga.m1.Catalogue.class, "getCatalogue", new Class[] {},
				"missing method getCatalogue() in class Catalogue");
	}
	/*
	public void testAjouteUnivers() {
		Univers hight=new Univers("High-Tech");
		Catalogue catalogue = new Catalogue(hight);
		
		Produit asus = new Produit("Asus ROG","PC Gamer",1,899.0F);
		Produit hp = new Produit("HP ENVY","PC Portable",1,999.0F);
		Produit mac = new Produit("MacBook Air","PC Portable",1,1299.0F);

	}
*/
	protected void runTests() {
		this.testExpected = 5;
		try {
			testDeclaredMethods();			
		} catch (Exception e) {e.printStackTrace();}
		try {
			testDeclaredConstructors();			
		} catch (Exception e) {e.printStackTrace();}
	}
}
