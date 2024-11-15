package jeu;

import java.util.Iterator;
import java.io.*;
import java.lang.*;
import java.util.*;

import cartes.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import utils.GestionCartes;

import java.util.ListIterator;
import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;

public class Jeu {
	Sabot<Carte> sabot;
	Set<Joueur> joueurs;
	public Iterator<Joueur> iterJoueur;
	final int NBCARTES = 8;

	public Jeu() {
		JeuDeCartes jeuDeCartes = new JeuDeCartes();
		List<Carte> listeCartes = new ArrayList<>(Arrays.asList(jeuDeCartes.donnerCartes()));
		listeCartes = GestionCartes.melanger(listeCartes);
		Carte[] tabCartesMelangees = new Carte[listeCartes.size()];
		int numCarte = 0;
		for (Carte carte : listeCartes) {
			tabCartesMelangees[numCarte] = carte;
			numCarte++;
		}
		joueurs = new HashSet<>();
		sabot = new Sabot<Carte>(tabCartesMelangees);
		this.iterJoueur = joueurs.iterator();

	}

	public void inscrire(Joueur... joueursAInscricre) {
		for (Joueur joueur : joueursAInscricre) {
			joueurs.add(joueur);
		}
	}

	public void distribuerCartes() {
		for (int i = 1; i < NBCARTES; i++) {
			for (Joueur joueur : joueurs) {

				joueur.prendreCarte(sabot);
			}
		}
	}

	public String jouerTour(Joueur joueur) {
		StringBuilder chaine = new StringBuilder();
		Carte carte = joueur.prendreCarte(sabot);
		chaine.append(
				"Le joueur " + joueur.getNom() + " a pioche " + carte.toString() + "\n" + joueur.getMain().toString());
		chaine.append(joueur.getNom() + " depose la carte " + carte.toString() + " dans ");
		Coup coup = joueur.choisirCoup(joueurs);
		joueur.retirerDeLaMain(carte);
		Joueur joueurCible = coup.getJoueurCible();
		if (joueurCible == null) {
			sabot.ajouterCarte(carte);
			chaine.append("sa zone de jeu\n");

		} else {
			joueurCible.deposer(carte);
			chaine.append("la zone de jeu de " + joueurCible.getNom() + "\n");
		}
		System.out.println(chaine.toString());
		return chaine.toString();
	}

	public Joueur donnerJoueurSuivant() {
		if (!iterJoueur.hasNext()) {
			iterJoueur = joueurs.iterator();
		}
		return iterJoueur.next();

	}

	public void lancer() {
		do {

			Joueur joueur = donnerJoueurSuivant();
			StringBuilder chaine = new StringBuilder();
			Carte carte = joueur.prendreCarte(sabot);
			chaine.append("Le joueur " + joueur.getNom() + " a pioche " + carte.toString() + "\n"
					+ joueur.getMain().toString());
			chaine.append(joueur.getNom() + " depose la carte " + carte.toString() + " dans ");
			Coup coup = joueur.choisirCoup(joueurs);
			joueur.retirerDeLaMain(carte);
			Joueur joueurCible = coup.getJoueurCible();
			if (joueurCible == null) {
				sabot.ajouterCarte(carte);
				chaine.append("sa zone de jeu\n");

			} else {
				joueurCible.deposer(carte);
				chaine.append("la zone de jeu de " + joueurCible.getNom() + "\n");
			}
			System.out.println(chaine.toString());
			for (Joueur joueura : joueurs) {
				System.out.println("Total des bornes " + joueura.getNom() + " : " + joueura.donnerKmParcourus());
			}
			System.out.println("\n");

		} while (!sabot.estVide());
		Gagnant();
		System.out.println(classement());

	}

	public Joueur Gagnant() {
		for (Joueur joueur : joueurs) {

			if (joueur.getZoneDeJeu().donnerKmParcourus() == 1000) {
				System.out.println("\n\nGagnant : " + joueur.getNom());
				return joueur;
			}

		}
		return null;
	}

	public Set<Joueur> classement() {
		Set<Joueur> classement = new TreeSet<>(new JoueurCompareKm());
		for (Joueur joueur : joueurs) {
			classement.add(joueur);
		}

		return classement;
	}

	private static class JoueurCompareKm implements Comparator<Joueur> {
		@Override
		public int compare(Joueur j1, Joueur j2) {
			return Integer.compare(j2.donnerKmParcourus(), j1.donnerKmParcourus());

		}
	}

}
