package jeu;

import cartes.*;
import java.util.ArrayList;
import java.util.Set;
import utils.GestionCartes;

import java.util.ListIterator;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;

public class Jeu {
	Sabot sabot;
	Set<Joueur> joueurs;
	final int NBCARTES = 6;

	public Jeu() {
		JeuDeCartes jeuDeCartes = new JeuDeCartes();
		List<Carte> listeCartes = new ArrayList<>(Arrays.asList(jeuDeCartes.donnerCartes()));
		GestionCartes.melanger(listeCartes);
		joueurs = new HashSet<>();
		sabot = new Sabot();
		
		Carte[] cartesMelangees = listeCartes.toArray(new Carte[0]);
		for (Carte carte : cartesMelangees) {
			sabot.ajouterCarte(carte);
		}
	}

	public void inscrire(Joueur... joueursAInscricre) {
		for (Joueur joueur : joueursAInscricre) {
			joueurs.add(joueur);
		}
	}

	public void distribuerCartes() {
		for (int i = 0; i < NBCARTES; i++) {
			for (Joueur joueur : joueurs) {
				joueur.prendreCarte(sabot);
			}
		}
	}

	public String jouerTour(Joueur joueur) {
		StringBuilder chaine = new StringBuilder();
		Carte carte = joueur.prendreCarte(sabot);
		chaine.append(
				"Le joueur " + joueur.getNom() + " a pioche " + carte.toString() + joueur.getMain().toString() + "\n");
		chaine.append(joueur.getNom() + " depose la carte " + carte.toString() + " dans ");
		Coup coup = joueur.choisirCoup(joueurs);
		joueur.retirerDeLaMain(carte);
		Joueur joueurCible = coup.getJoueurCible();
		if (joueurCible == null) {
			sabot.ajouterCarte(carte);
			chaine.append("sa zone de jeu\n");

		} else {
			joueurCible.deposer(carte);
			chaine.append("dans la zone de jeu de " + joueurCible.getNom());
		}

		return chaine.toString();
	}

}
