package testsFonctionnels;

import cartes.JeuDeCartes;

public class TestJeuDeCartes {
	public static void main(String[] args) {

		/*
		 * -------------------------------------------------- TP1
		 * --------------------------------------------------------
		 */
		JeuDeCartes jeu = new JeuDeCartes();
		System.out.println("JEU:\n" + jeu.affichageJeuDeCartes());
		jeu.checkCount();

//        if (!jeu.checkCount()) {
//            System.out.println("erreur de nombre");
//        }

	}
}