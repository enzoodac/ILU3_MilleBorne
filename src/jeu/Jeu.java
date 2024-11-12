package jeu;

import cartes.*;
import java.util.ArrayList;
import java.util.Set;
import utils.GestionCartes;

import java.util.ListIterator;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Jeu {
	Sabot sabot;
	Set<Joueur> joueurs;
	final int NBCARTES = 6;
	private Carte[] cartesMelangees;

	public Jeu() {
		JeuDeCartes jeuDeCartes = new JeuDeCartes();
		List<Carte> listeCartes = new ArrayList<>(Arrays.asList(jeuDeCartes.donnerCartes()));

		
		List<Carte> listeCartesMelangee = GestionCartes.melanger(listeCartes);
		
		joueurs = new HashSet<>();
		sabot = new Sabot();
		
		 cartesMelangees = new Carte[listeCartesMelangee.size()];
		 for (int i = 0; i < cartesMelangees.length; i++) {
			 cartesMelangees[i] = listeCartesMelangee.get(i);
		}
		
		
	
		
	}

	public void inscrire(Joueur... joueursAInscricre) {
		for (Joueur joueur : joueursAInscricre) {
			joueurs.add(joueur);
		}
	}

	public void distribuerCartes() {
		int numCarte = 0;
		for (int i = 0; i < NBCARTES; i++) {
			for (Joueur joueur : joueurs) {
				
				joueur.donner(cartesMelangees[numCarte]);
				numCarte++;//Donner!!!
			}
		}
	}

	public String jouerTour(Joueur joueur) {
		StringBuilder chaine = new StringBuilder();
		Carte carte = joueur.prendreCarte(sabot);
		chaine.append("Le joueur " + joueur.getNom() + " a pioche " + carte.toString() + "\n"
				+ joueur.getMain().toString() + "\n");
		chaine.append(joueur.getNom() + " depose la carte " + carte.toString() + " dans ");
		Coup coup = joueur.choisirCoup(joueurs);
		joueur.retirerDeLaMain(carte);
		Joueur joueurCible = coup.getJoueurCible();
		if (joueurCible == null) {
			sabot.ajouterCarte(carte);					//Warning
			chaine.append("sa zone de jeu\n");

		} else {
			joueurCible.deposer(carte);
			chaine.append("dans la zone de jeu de " + joueurCible.getNom());
		}
		System.out.println(chaine.toString());
		return chaine.toString();
	}

}
