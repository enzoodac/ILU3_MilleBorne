package strategies;

import jeu.*;

import java.util.Comparator;
import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Random;
import java.util.TreeSet;

import java.util.Set;

import cartes.*;

public interface Strategie {

	public default NavigableSet<Coup> trierCoups(Set<Coup> coupsATrier) {
		assert (!coupsATrier.isEmpty());
		NavigableSet<Coup> coupsTries = new TreeSet<>(new DefaultSort());
		coupsTries.addAll(coupsATrier);

		return coupsTries;

	}

	public default Coup selectionnerCoup(Set<Coup> choixCoups) {
		return trierCoups(choixCoups).last();
	}

	public default Coup selectionnerDefausse(Set<Coup> choixCoups) {
		return trierCoups(choixCoups).first();
	}

	public static class DefaultSort implements Comparator<Coup> {

		@Override
		public int compare(Coup c1, Coup c2) {
			if (c1.equals(c2)) {
				return 0;
			} else {
				Random random = new Random();
				return random.nextBoolean() ? -1 : 1;
			}
		}
	}

}
