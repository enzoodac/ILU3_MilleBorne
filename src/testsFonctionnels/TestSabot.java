package testsFonctionnels;

import java.util.Iterator;
import jeu.Sabot;
import cartes.*;

public class TestSabot {

	public static void main(String[] args) {
		Sabot sabot = new Sabot<Carte>();
//			for(int i=0; i<106; i++) {
//				sabot.piocher();
//				System.out.println(i);
//			}
		Iterator<Carte> iter = sabot.iterator();
		int index = 0;
		while (iter.hasNext()) {
			Carte carte = iter.next();
			index++;
			System.out.println("Je pioche " + carte.toString());
			iter.remove();
			

		}

	}
}