package jeu;

import cartes.*;
import utils.GestionCartes;

import java.util.ListIterator;
import java.util.List;
import java.util.Arrays;

public class Jeu {
	Sabot sabot;

	public Jeu() {
		JeuDeCartes jeuDeCartes = new JeuDeCartes();
		List<Carte> listeCartes = Arrays.asList(jeuDeCartes.donnerCartes());
		GestionCartes.melanger(listeCartes);
		this.sabot = sabot;
		sabot = new Sabot();
		Carte[] cartesMelangees = listeCartes.toArray(new Carte[0]);
		for(Carte carte : cartesMelangees) {
			sabot.ajouterCarte(carte);
		}
	}

}
