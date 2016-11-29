package fr.uga.m1;

import java.util.Scanner;

public class MagasinTest {

	public static void main(String[] args) {
		int choix = 0;
		Scanner scanne = new Scanner(System.in);
		System.out.println("Faites votre choix :");
		System.out.println("1--Consulter les produits du magasin\n"
				+ "2--Selectionner Produit\n3--Reserver un produit consulter\n4-Valider le panier ");
		choix = scanne.nextInt();
		switch (choix) {
		case 1:
			consulterProduit();
			break;
		case 2:
			selectionnerProduit();
			break;
		case 3:
			reserverProduit();
			break;
		case 4:
			validerPanier();
			break;
		default:
			System.out.println("Votre choix n'est pas valide");
		}
		scanne.close();
	}

	private static void validerPanier() {
		// TODO Auto-generated method stub
		System.out.println("Valider");
	}

	private static void reserverProduit() {
		// TODO Auto-generated method stub
		System.out.println("Reserver");
	}

	private static void selectionnerProduit() {
		// TODO Auto-generated method stub
		System.out.println("Selectionner");
	}

	private static void consulterProduit() {
		// TODO Auto-generated method stub
		System.out.println("Consulter");
	}

}
