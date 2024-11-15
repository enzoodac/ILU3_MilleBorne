package cartes;

import java.util.HashMap;
import java.util.Map;

public class JeuDeCartes {
	Map<Carte, Integer> cartes;

	public JeuDeCartes() {

		cartes = new HashMap<>();
		cartes.put(new Borne(25), 10);
		cartes.put(new Borne(50), 10);
		cartes.put(new Borne(75), 10);
		cartes.put(new Borne(100), 12);
		cartes.put(new Borne(200), 4);
		cartes.put(new Parade(Type.FEU), 14);
		cartes.put(new Parade(Type.ESSENCE), 6);
		cartes.put(new Parade(Type.CREVAISON), 6);
		cartes.put(new Parade(Type.ACCIDENT), 6);
		cartes.put(new Attaque(Type.FEU), 5);
		cartes.put(new Attaque(Type.ESSENCE), 3);
		cartes.put(new Attaque(Type.CREVAISON), 3);
		cartes.put(new Attaque(Type.ACCIDENT), 3);
		cartes.put(new Botte(Type.ESSENCE), 1);
		cartes.put(new Botte(Type.CREVAISON), 1);
		cartes.put(new Botte(Type.ACCIDENT), 1);
		cartes.put(new Botte(Type.FEU), 1);
		cartes.put(new DebutLimite(), 4);
		cartes.put(new FinLimite(), 6);

	}

	public String affichageJeuDeCartes() {
		StringBuilder jeu = new StringBuilder();
		for (Map.Entry<Carte, Integer> entry : cartes.entrySet()) {
			Carte key = entry.getKey();
			Integer val = entry.getValue();
			jeu.append(val + " " + key.toString() + "\n");
		}
		return jeu.toString();
	}

	public Carte[] donnerCartes() {
		int nbCartes = 0;
		for (Map.Entry<Carte, Integer> entry : cartes.entrySet()) {
			nbCartes += entry.getValue();
		}
		Carte[] cartesGiven = new Carte[nbCartes];
		int index = 0;
		for (Map.Entry<Carte, Integer> entry : cartes.entrySet()) {
			Carte carte = entry.getKey();
			int key = entry.getValue();
			for (int i = 0; i < key; i++) {
				cartesGiven[index] = carte;
				index++;
			}
		}
		return cartesGiven;
	}

	public boolean checkCount() {
		int nbExpected = 106;
		int actualCount = 0;
		for (Map.Entry<Carte, Integer> entry : cartes.entrySet()) {
			actualCount += entry.getValue();
		}

		return nbExpected == actualCount;
	}

//	public class Configuration {
//		private int nbExemplaires;
//		private Carte carte;
//
//		public Configuration(int nbExemplaires, Carte carte) {
//			super();
//			this.nbExemplaires = nbExemplaires;
//			this.carte = carte;
//		}
//
//		public Carte getCarte() {
//			return carte;
//		}
//
//		public int getnbExemplaires() {
//			return nbExemplaires;
//		}
//
//	}

}
