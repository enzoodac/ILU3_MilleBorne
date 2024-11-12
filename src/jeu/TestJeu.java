package jeu;

import cartes.*;
import jeu.*;

public class TestJeu {

	public static void main(String[] args) {
		Jeu jeu = new Jeu();
	
		Joueur jack = new Joueur("Jack");
		Joueur bill = new Joueur("Bill");
		Joueur luffy = new Joueur("Luffy");
		
		jeu.inscrire(jack, bill, luffy);
		jeu.distribuerCartes();
		jeu.jouerTour(jack);
		jeu.jouerTour(bill);
		jeu.jouerTour(luffy);
		

	}

}
