package fr.uga.m1;

import java.util.Scanner;

public class Magasin {

	private static Scanner scanne;

	public static void main(String[] args) {
		Catalogue catalogue = new Catalogue("MIAGE PC");
		Panier panier = new Panier();
		Univers photo = new Univers("Photo");
		photo.ajouteProduit(new Produit("CD OG", "last album K2A", 1, 12.99F));
		photo.ajouteProduit(new Produit("Vinyle", "Standing On The Beach", 2, 20.0F));
		photo.ajouteProduit(new Produit("B.B. King", "Live At The Regal", 1, 10.0F));
		photo.ajouteProduit(new Produit("Nevermind", " Pulp Fiction", 1, 12.99F));

		Univers audio = new Univers("Audio");
		Produit micro = new Produit("Micro ATR3350", "Microphone audio cravate", 1, 12.99F);
		Produit vinyle = new Produit("Vinyle", "Standing On The Beach", 2, 20.0F);
		audio.ajouteProduit(micro);
		audio.ajouteProduit(vinyle);
		audio.ajouteProduit(new Produit("B.B. King", "Live At The Regal", 1, 10.0F));
		audio.ajouteProduit(new Produit("Nevermind", " Pulp Fiction", 1, 12.99F));

		Univers drones = new Univers("Drones");
		Produit simToo = new Produit("SimToo", "Dragonfly Pro V2 4K", 1, 60.0F);
		Produit eachine = new Produit("Eachine", "Tiny Whoops X73 FPV", 2, 89.0F);
		Produit parot = new Produit("Parrot", "minidrone Parrot MAMBO", 3, 99.0F);
		drones.ajouteProduit(simToo);
		drones.ajouteProduit(eachine);
		drones.ajouteProduit(parot);

		catalogue.ajouteUnivers(photo);
		catalogue.ajouteUnivers(drones);
		catalogue.ajouteUnivers(audio);
		scanne = new Scanner(System.in);
		int choix = 0;
		menu();
		choix = scanne.nextInt();

		while (choix != 6) {
			switch (choix) {
			case 1:
				lancerScenario(catalogue, panier);
				break;
			case 2:
				scanne.nextLine();
				System.out.println("Entrer le nom du produit ");
				String prod = scanne.nextLine();
				Produit p = chercherProduit(catalogue, prod);
				if (p == null) {
					System.out.println("ce produit ne fait pas parti du catalogue");
				}
				creerPanier(panier, p);
				break;
			case 3:
				scanne.nextLine();
				System.out.println("Entrer le nom du produit ");
				String sup = scanne.nextLine();
				Produit produit = new Produit(sup, "", 1, 0.0F);
				modifierPanier(panier, produit);
				break;
			case 4:
				consulterCatalogue(catalogue);
				break;
			case 5:
				validerCommande(panier);
				break;
			default:
				System.out.println("Au plaisir de vous revoir !!!!");
				break;
			}
			System.out.println("\nFaite un choix");
			choix = scanne.nextInt();
		}

	}

	public static void consulterCatalogue(Catalogue catalogue) {
		System.out.println(catalogue.toString());
	}

	public static boolean validerCommande(Panier panier) {
		return panier.passerCommande();
	}

	private static void creerPanier(Panier panier, Produit produit) {
		panier.ajouterLigneCommande(produit);
		System.out.println(panier.toString());
	}

	private static void modifierPanier(Panier panier, Produit produit) {
		panier.modifierLigneCommande(produit, -1);
		System.out.println(panier.toString());
	}

	public static Produit chercherProduit(Catalogue c, String s) {
		UniversIteratorImpl ui = new UniversIteratorImpl(c.getCatalogue());
		Produit product = null;
		while (ui.hasNext()) {
			Univers univers = ui.next();
			for (Produit pro : univers.getListProduit()) {
				if (pro.getNom().equalsIgnoreCase(s)) {
					product = pro;
				}
			}
		}
		return product;
	}

	public static void menu() {
		System.out.println("1. Lancer scenario");
		System.out.println("2. Lancer mode interactif");
		System.out.println("3. Modifier panier mode interactif");
		System.out.println("4. Afficher le catalogue");
		System.out.println("5. Passer commande");
		System.out.println("6. Sortir");
	}

	private static void lancerScenario(Catalogue catalogue, Panier panier) {
		Univers audio = new Univers("Audio");
		Produit micro = new Produit("Micro ATR3350", "Microphone audio cravate", 1, 12.99F);
		Produit vinyle = new Produit("Vinyle", "Standing On The Beach", 2, 20.0F);
		audio.ajouteProduit(micro);
		audio.ajouteProduit(vinyle);
		audio.ajouteProduit(new Produit("B.B. King", "Live At The Regal", 1, 10.0F));
		audio.ajouteProduit(new Produit("Nevermind", " Pulp Fiction", 1, 12.99F));

		Univers drones = new Univers("Drones");
		Produit simToo = new Produit("SimToo", "Dragonfly Pro V2 4K", 1, 60.0F);
		Produit eachine = new Produit("Eachine", "Tiny Whoops X73 FPV", 2, 89.0F);
		Produit parot = new Produit("Parrot", "minidrone Parrot MAMBO", 3, 99.0F);
		drones.ajouteProduit(simToo);
		drones.ajouteProduit(eachine);
		drones.ajouteProduit(parot);

		catalogue.ajouteUnivers(drones);
		catalogue.ajouteUnivers(audio);

		/* remplir le panier **/
		System.out.println("\n\tCreation du panier");

		/***********************************************************
		 *********************** ETAT NON VALIDE *******************
		 ***********************************************************/
		System.out.print("Etat du panier a sa creation \t");
		System.out.println(panier.getEtat());
		System.out.print("\nAjout de produit micro dans le panier de: \t");
		panier.ajouterLigneCommande(micro);
		System.out.println(panier.toString());
		System.out.print("\nAjout de produit vinyle dans le panier de: \t");
		panier.ajouterLigneCommande(vinyle);
		System.out.println(panier.toString());
		System.out.println("On supprime le micro du panier");
		panier.enleverLigneCommande(micro);
		System.out.println(panier.toString());

		/************************************************************
		 *********************** ETAT PRECOMMANDE ******************
		 ************************************************************/
		panier.changeEtat(new EtatPreValide(panier));
		System.out.println("\nTest ajout produit dans l'etat preValide");
		panier.ajouterLigneCommande(parot);
		System.out.println(panier.toString());
		System.out.println("Suppression du vinyle dans l'etat preValide");
		panier.enleverLigneCommande(vinyle);

		System.out.println(panier.toString());
		System.out.println("\nTest modification produit dans l'etat preValide");
		panier.setEtat(new EtatNonValide(panier));

		System.out.println("ajout de nouveau produit dans le panier dont l'etat est passer a non valide ");
		panier.ajouterLigneCommande(eachine);
		System.out.println(panier.toString());
		System.out.println("\nAjout de 2 eachines dans le panier ");
		panier.modifierLigneCommande(eachine, 2);
		System.out.println(panier.toString());
		panier.setEtat(new EtatPreValide(panier));

		/************************************************************
		 *********************** ETAT VALIDE ******************
		 ************************************************************/
		panier.setEtat(new EtatValide(panier));
		System.out.println("\nTest ajout dans panier valider");
		panier.ajouterLigneCommande(simToo);
		System.out.println("\nTest suppression dans panier valider");
		panier.enleverLigneCommande(simToo);
		System.out.println("\nTest modification dans panier valider");
		panier.modifierLigneCommande(simToo, 1);
		System.out.println(panier.toString());
	}
}
