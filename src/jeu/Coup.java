package jeu;

import jeu.Joueur;
import cartes.*;

public class Coup {
	private Joueur joueurCourant;
	private Joueur joueurCible;
	private Carte carteJouee;
	private boolean gotSabot = false;

	public Coup(Joueur joueurCourant, Joueur joueurCible, Carte carteJouee) {
		this.joueurCourant = joueurCourant;
		this.carteJouee = carteJouee;
		if (joueurCible == null)
			gotSabot = true;
		else
			this.joueurCible = joueurCible;
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

		return (carteJouee instanceof Attaque || carteJouee instanceof DebutLimite);
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
