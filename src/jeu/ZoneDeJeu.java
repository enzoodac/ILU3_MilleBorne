package jeu;

import java.util.ListIterator;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import cartes.*;

public class ZoneDeJeu {
	private List<Limite> limites;
	private List<Bataille> batailles;
	private List<Borne> bornes;
	private HashSet<Botte> bottes;

	public ZoneDeJeu() {
		limites = new ArrayList<Limite>();
		batailles = new ArrayList<Bataille>();
		bornes = new ArrayList<Borne>();
		bottes = new HashSet<Botte>();

	}

	public boolean estPrioritaire() {
		return bottes.contains(new Botte(Type.FEU));
	}

	public int donnerLimitationVitesse() {
		int limite;
		if (limites.isEmpty() || limites.get(0) instanceof FinLimite || estPrioritaire()) {
			limite = 200;
		} else {
			limite = 50;
		}
		// System.out.println("Limite : " + limite);
		return limite;
	}

	public int donnerKmParcourus() {
		int parcouru = 0;
		for (Borne borne : bornes) {
			parcouru += borne.getKm();
		}
		System.out.println("Total des bornes : " + parcouru);
		return parcouru;
	}

	public void deposer(Carte c) {
		// System.out.println("Deposer carte " + c.toString());
		switch (c) {
		case Borne borne:
			bornes.addFirst(borne);
			break;

		case Limite limite:
			limites.addFirst(limite);
			break;

		case Bataille bataille:
			batailles.addFirst(bataille);
			break;
		case Botte botte:
			bottes.add(botte);
		default:
			throw new ClassCastException();

		}
	}

	public boolean peutAvancer() {
		
		Bataille sommetBatailles = batailles.getFirst();
		System.out.println("HERE!!");
		boolean cond1 = batailles.isEmpty() && estPrioritaire();
		
		boolean cond2 = sommetBatailles instanceof Parade && sommetBatailles.getType().equals(Type.FEU);
		boolean cond3 = sommetBatailles instanceof Parade && estPrioritaire();
		boolean cond4 = sommetBatailles instanceof Attaque && sommetBatailles.getType().equals(Type.FEU)
				&& estPrioritaire();
		boolean cond5 = sommetBatailles instanceof Attaque && bottes.contains(new Botte(sommetBatailles.getType()))
				&& estPrioritaire();

		return cond1 || cond2 || cond3 || cond4 || cond5;
	}

	private boolean estDepotFeuVertAutorise() {

		Bataille sommetBatailles = batailles.getFirst();

		return !estPrioritaire()
				&& (batailles.isEmpty()
						|| (sommetBatailles) instanceof Attaque && sommetBatailles.getType().equals(Type.FEU))
				|| (sommetBatailles instanceof Parade && !sommetBatailles.getType().equals(Type.FEU))
				|| (sommetBatailles instanceof Attaque && bottes.contains(new Botte(sommetBatailles.getType())));
	}

	private boolean estDepotBorneAutorise(Borne borne) {
		return peutAvancer() && borne.getKm() <= donnerLimitationVitesse()
				&& donnerKmParcourus() + borne.getKm() <= 1000;
	}

	private boolean estDepotLimiteAutorise(Limite limite) {
		boolean cond = false;
		if (estPrioritaire()) {
			return false;
		}
		switch (limite) {
		case DebutLimite debutLimite -> cond = limites.isEmpty() || limites.getFirst() instanceof FinLimite;
		case FinLimite finLimite -> cond = limites.getFirst() instanceof DebutLimite;

		default -> throw new IllegalArgumentException("Unexpected value: " + limite);
		}
		return cond;
	}

	private boolean estDepotBatailleAutorise(Bataille bataille) {
		
		if (bottes.contains(new Botte(bataille.getType()))) {  				
			
			return false;
		}
		
		if (bataille instanceof Attaque && peutAvancer()) {
			
			return true;
		}
			
		else if (bataille instanceof Parade) {
			if (bataille.equals(Cartes.feuVert)) {
				return estDepotFeuVertAutorise();
			} else {
				if (!batailles.isEmpty() && batailles.getFirst().getType() == bataille.getType()) {
					return true;
				}
			}
		}
		return false;

	}

	public boolean estDepotAutorise(Carte carte) {
		if (carte instanceof Botte)
			return true;
		if (carte instanceof Borne borne)
			return estDepotBorneAutorise(borne);
		if (carte instanceof Limite limite)
			return estDepotLimiteAutorise(limite);
		if (carte instanceof Bataille bataille)
			return estDepotBatailleAutorise(bataille);

		return false;
	}

}
