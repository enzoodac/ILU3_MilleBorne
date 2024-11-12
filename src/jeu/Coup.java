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

		boolean cond1 = !(carteJouee instanceof Attaque || carteJouee instanceof DebutLimite && joueurCible == null);
		boolean cond2 = true;
		if (carteJouee instanceof Borne) {

			Borne borne = (Borne) carteJouee;
			int km = borne.getKm();
			cond2 = joueurCourant.getZoneDeJeu().donnerKmParcourus() + km <= 1000;
		}

		return cond1 && cond2;

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
