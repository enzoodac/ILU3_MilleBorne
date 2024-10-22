package jeu;

import java.util.List;
import java.util.Iterator;
import java.lang.Iterable;
import cartes.*;

public class MainJoueur implements Iterable<Carte> {
	private List<Carte> main;

	public void prendre(Carte carte) {
		main.add(carte);

	}

	public void jouer(Carte carte) {
		assert (main.contains(carte));
		main.remove(carte);

	}

	@Override
	public Iterator<Carte> iterator() {
		return main.iterator();
	}

	@Override
	public String toString() {
		StringBuilder chaine = new StringBuilder();
		for (Carte carte : main) {
			chaine.append(carte.toString());
		}
		return chaine.toString();
	}
	
	
}
