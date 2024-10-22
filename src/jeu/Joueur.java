package jeu;

import cartes.*;

public class Joueur {
	private String nom;
	private ZoneDeJeu zoneDeJeu;
	private MainJoueur main;

	public Joueur(String nom, ZoneDeJeu zoneDeJeu) {
		super();
		this.nom = nom;
		this.zoneDeJeu = zoneDeJeu;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Joueur) {
			Joueur joueur = (Joueur) obj;
			if (joueur.getNom().equals(this.nom)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return nom;
	}

	public void donner(Carte carte) {
		main.prendre(carte);
	}

	public Carte prendreCarte(Sabot sabot) {

		if (sabot.estVide()) {
			return null;
		}
		Carte carte = sabot.piocher();
		return carte;
	}

}
