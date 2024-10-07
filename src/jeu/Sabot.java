package jeu;

import java.util.Iterator;
import cartes.*;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sabot<T extends Carte> implements Iterable<T> {
	private int nbCartes = 0;
	private Carte[] cartes;
	private int nombreOperations = 0;

	public Sabot() {
		JeuDeCartes jeu = new JeuDeCartes();
		// this.cartes = jeu.donnerCartes();

		this.cartes = jeu.donnerCartes();
		this.nbCartes = cartes.length;
	}

	public boolean estVide() {
		return nbCartes == 0;
	}

	public void ajouterCarte(Carte carte) {

		if (nbCartes >= cartes.length)
			throw new IndexOutOfBoundsException();

		try {
			cartes[nbCartes] = carte;
			nbCartes++;
			nombreOperations++;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public T piocher() {
		Iterator<T> iter = this.iterator();
		if (!iter.hasNext()) {
			throw new NoSuchElementException("Pioche interdite dans un sabot vide !");
		}
		//System.out.println(iter.next());
		T carte = iter.next();
		System.out.println("Je pioche " + carte.toString());
		iter.remove();
		
		return carte;

	}

	public Iterator<T> iterator() {
		return new Iterateur();
	}

	private class Iterateur implements Iterator<T> {
		private boolean nextEffectue = false;
		private int indiceIterateur = 0;
		private int nombreOperationReference = nombreOperations;
		
		@Override
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}
		@Override
		public T next() {
			verificationConcurrence();
			if (hasNext()) {
				T carte = (T) cartes[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return carte;
			} else {
				throw new NoSuchElementException();
			}

		}
		@Override
		public void remove() {
			verificationConcurrence();
			if (!nextEffectue || nbCartes < 1) {
				throw new NoSuchElementException();
			}
			// decalage des elements pour supprimer l'element souhaite
			for (int i = indiceIterateur-1; i < nbCartes - 1; i++) {
				cartes[i] = cartes[i + 1];

			}
			cartes[nbCartes - 1] = null;
			nbCartes--;
			nextEffectue = false;
			indiceIterateur--;
			nombreOperations++;
			nombreOperationReference++;
			
			

		}

		public void verificationConcurrence() {
			if (nombreOperationReference != nombreOperations)
				throw new ConcurrentModificationException();
		}

	}

}
