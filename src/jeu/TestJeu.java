package jeu;

import cartes.*;
import jeu.*;

public class TestJeu {

	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		ZoneDeJeu zoneJack = new ZoneDeJeu();
		ZoneDeJeu zoneBill = new ZoneDeJeu();
		ZoneDeJeu zoneLuffy = new ZoneDeJeu();

		Joueur jack = new Joueur("Jack", zoneJack);
		Joueur bill = new Joueur("Bill", zoneBill);
		Joueur luffy = new Joueur("Luffy", zoneLuffy);
		
		jeu.inscrire(jack, bill, luffy);
		
		jeu.distribuerCartes();
		jeu.jouerTour(jack);
		jeu.jouerTour(bill);
		jeu.jouerTour(luffy);

	}

}
