package testsFonctionnels;

import cartes.*;
import java.util.LinkedList;
import utils.GestionCartes;
import java.util.ArrayList;
import java.util.List;

public class TestGestionCartes {

	public static void main(String[] args) {
//		GestionCartes test = new GestionCartes();
//		List<String> cartes = new ArrayList<>();
//		// Ajout des éléments dans la liste
//		cartes.add("Borne50");
//		cartes.add("FeuVert");
//
//		cartes.add("FeuVert");
//		cartes.add("Borne25");
//		cartes.add("Borne25");
//		cartes.add("Borne100");
//		cartes.add("FeuRouge");
//		cartes.add("FeuRouge");
//		cartes.add("FinLimite");
//		cartes.add("DebutLimite");
//		cartes.add("Borne50");
//		cartes.add("Borne50");
//
////		List<String> sortie = test.rassembler(cartes);
////		int index=0;
////		System.out.println("triee");
////		while(index<sortie.size()) {
////			System.out.println(sortie.get(index));
////			index++;
////		}
////		List<String> melangee = new ArrayList<>();
////		melangee = test.melanger(sortie);
////		System.out.println("\nmelangee");
////		index=0;
////		while(index<melangee.size()) {
////			System.out.println(melangee.get(index));
////			index++;
////		}
//
//		System.out.println(test.verifierRassemblement(cartes));

		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = new LinkedList<>();
		for (Carte carte : jeu.donnerCartes()) {
			listeCarteNonMelangee.add(carte);
		}
		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
		System.out.println(listeCartes);

		listeCartes = GestionCartes.melanger(listeCartes);
		System.out.println(listeCartes);
		System.out.println("rassemblee ? " + GestionCartes.verifierRassemblement(listeCartes));
		System.out.println(
				"liste mélangée sans erreur ? " + GestionCartes.verifierMelange(listeCarteNonMelangee, listeCartes));
		listeCartes = GestionCartes.rassembler(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste rassemblée sans erreur ? " + GestionCartes.verifierRassemblement(listeCartes));
		List<Integer> listeInt = new ArrayList<>();
		listeInt.add(1);
		listeInt.add(4);
		listeInt.add(3);
		listeInt.add(2);
		System.out.println(GestionCartes.verifierRassemblement(listeInt));

	}
}
