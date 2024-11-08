package jeu;

import jeu.Joueur;
import cartes.*;

public class Coup {
	private Joueur joueurCourant;
	private Joueur joueurCible;
	private Carte carteJouee;

	public Coup(Joueur joueurCourant, Joueur joueurCible, Carte carteJouee) {
		this.joueurCourant = joueurCourant;
		this.joueurCible = joueurCible;
		this.carteJouee = carteJouee;

	}

	public Joueur getJoueurCourant() {
		return joueurCourant;
	}

	public Joueur getJoueurCible() {
		return joueurCible;
	}

	public Carte getCarteJouee() {
		return carteJouee;
	}

	public boolean estValide() {

		if (carteJouee instanceof Attaque || carteJouee instanceof DebutLimite) {
			return !(joueurCible == null);
		} else {
			return true;
		}

	}

	@Override
	public String toString() {
		if (!(joueurCible == null)) {
			return "depose de la carte " + carteJouee.toString() + "dans la zone de " + joueurCible.getNom();
		} else {
			return "defausse de la carte " + carteJouee.toString();
		}
	}
}
