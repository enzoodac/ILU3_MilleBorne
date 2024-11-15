package jeu;

import cartes.*;
import strategies.*;
import strategies.Strategie.DefaultSort;

import java.util.Random;
import jeu.Coup;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class Joueur implements Comparable<Joueur> {
	private String nom;
	private ZoneDeJeu zoneDeJeu;
	private MainJoueur main;
	private Strategie strategie;

	public Joueur(String nom) {
		super();
		this.nom = nom;
		this.main = new MainJoueur();
		this.zoneDeJeu = new ZoneDeJeu();
		strategie = new Strategie() {
			@Override
			public NavigableSet<Coup> trierCoups(Set<Coup> coupsATrier) {
				assert (!coupsATrier.isEmpty());
				NavigableSet<Coup> coupsTries = new TreeSet<>(new DefaultSort());
				coupsTries.addAll(coupsATrier);

				return coupsTries;
			}

			@Override
			public Coup selectionnerCoup(Set<Coup> choixCoups) {
				return trierCoups(choixCoups).last();
			}

			@Override
			public Coup selectionnerDefausse(Set<Coup> choixCoups) {
				return trierCoups(choixCoups).first();
			}
		};
	}

	@Override
	public int compareTo(Joueur joueurToCompare) {
		int kmComparaison;

		if ((kmComparaison = Integer.compare(donnerKmParcourus(), joueurToCompare.donnerKmParcourus())) != 0) {
			return kmComparaison;
		} else {
			return nom.compareTo(joueurToCompare.getNom());
		}
	}

	public String getNom() {
		return nom;
	}

	public MainJoueur getMain() {
		return main;
	}

	public void setStrategie(Strategie strategie) {
		this.strategie = strategie;
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

//	public boolean estDepotAutorise1(Carte c) {
//		return zoneDeJeu.estDepotAutorise(c);
//	}

	@Override
	public String toString() {
		return nom;
	}

	public ZoneDeJeu getZoneDeJeu() {
		return zoneDeJeu;
	}

	public void donner(Carte carte) {
		main.prendre(carte);
	}

	public Carte prendreCarte(Sabot<Carte> sabot) {

		if (sabot.estVide()) {
			return null;
		}

		Carte carte = sabot.piocher();

		donner(carte);
		return carte;
	}

	public int donnerKmParcourus() {

		return zoneDeJeu.donnerKmParcourus();
	}

	public void deposer(Carte c) {

		zoneDeJeu.deposer(c);

	}

	public boolean estDepotAutorise(Carte c) {
		return zoneDeJeu.estDepotAutorise(c);
	}

	public HashSet<Coup> coupsPossibles(Set<Joueur> participants) {
		HashSet<Coup> setCoups = new HashSet<>();
		int nbCoupsValide = 0;
		for (Joueur partcicipant : participants) {
			if (!partcicipant.equals(this)) {
				for (Carte carte : main) {
					Coup coup = new Coup(this, partcicipant, carte);
					if (coup.estValide()) {
						setCoups.add(coup);
					}
				}
			}

		}
		return setCoups;

	}

	public Set<Coup> coupsDefausse() {
		Set<Coup> setCoups = new HashSet<>();
		for (Carte carte : main) {
			Coup coup = new Coup(this, null, carte);
			if (coup.estValide())
				setCoups.add(coup);
		}

		return setCoups;
	}

	public void retirerDeLaMain(Carte carte) {
		main.jouer(carte);
	}

	private Coup choixRandom(Set<Coup> coups) {
		Coup coup = null;
		int size = coups.size();
		Random random = new Random();
		int randomChoice = random.nextInt(size) + 1;
		Iterator<Coup> iterator = coups.iterator();
		int i = 0;
		while (i < randomChoice && iterator.hasNext()) {
			coup = iterator.next();
			i++;
		}
		return coup;
	}

	public Coup choisirCoup(Set<Joueur> participants) {
		Set<Coup> coupsPossibles = coupsPossibles(participants);
		Set<Coup> coupsDefausse = coupsDefausse();
		if (coupsPossibles.isEmpty()) {
			System.out.println("1");
			return strategie.selectionnerCoup(coupsDefausse);

		} else {
			// System.out.println("2");
			return strategie.selectionnerDefausse(coupsPossibles);
		}
	}

	public String afficherEtatJoueur() {
		StringBuilder chaine = new StringBuilder();
		Set<Botte> bottes = zoneDeJeu.getBottes();
		Iterator<Botte> iteBottes = bottes.iterator();
		chaine.append("Bottes : ");
		while (iteBottes.hasNext()) {
			chaine.append(iteBottes.next().toString());
		}
		chaine.append("\nLimitation de vitesse : " + (zoneDeJeu.donnerLimitationVitesse() == 50) + "\n");
		chaine.append("\n +Sommet Batailles : " + zoneDeJeu.getBatailles().getFirst().toString() + "\n");
		chaine.append(main.toString());

		return chaine.toString();
	}

}
