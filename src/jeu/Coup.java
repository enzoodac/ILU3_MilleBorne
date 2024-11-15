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
			cond2 = joueurCourant.estDepotAutorise(borne);
			if(joueurCible != null) {
				cond2 = false;
			}
		}

		return cond1 && cond2;

	}
	

	@Override
	public boolean equals(Object obj) {
	    if (obj instanceof Coup coup) {
	        // Comparaison pour joueurCourant
	        if (!joueurCourant.equals(coup.getJoueurCourant())) {
	            return false;
	        }

	        // Comparaison pour joueurCible en prenant en compte le cas null
	        if (joueurCible == null) {
	            if (coup.getJoueurCible() != null) {
	                return false;
	            }
	        } else if (!joueurCible.equals(coup.getJoueurCible())) {
	            return false;
	        }

	        // Comparaison pour carteJouee
	        return carteJouee.equals(coup.getCarteJouee());
	    }
	    return false;
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
