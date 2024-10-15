package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes {

	public static <T> T extraireV1(List<T> list) {
		if (list.isEmpty())
			throw new IllegalArgumentException("Empty list");
		Random random = new Random();
		int n = random.nextInt(list.size());
		T elem = list.get(n);
		list.remove(n);

		return elem;
	}

	public static <T> T extraireV2(List<T> list) {
		Random random = new Random();
		int n = random.nextInt(list.size());
		ListIterator<T> iter = list.listIterator();

		while (iter.nextIndex() < n) {
			iter.next();
		}
		T elem = iter.next();
		iter.remove();

		return elem;
	}

	public static <T> List<T> melanger(List<T> list) {
		List<T> listeMelangee = new ArrayList<>();
		while (!list.isEmpty()) {
			listeMelangee.add(extraireV1(list));
		}
		return listeMelangee;

	}

	public static <T> boolean verifierMelange(List<T> l1, List<T> l2) {
		int size = l1.size();
		if (size != l2.size())
			return false;
		for (T elem : l1) {
			if (Collections.frequency(l1, elem) != Collections.frequency(l2, elem)) {
				return false;
			}
		}

		return true;

	}

	public static <T> List<T> rassembler(List<T> list) {
		ArrayList<T> rassemblee = new ArrayList<>();
		int nbOccursMelangee = 0;
		int nbOcurrsRassemblee = 0;
		for (T elem : list) {
			nbOccursMelangee = Collections.frequency(list, elem);
			nbOcurrsRassemblee = Collections.frequency(rassemblee, elem);
			if (nbOcurrsRassemblee == 0) {
				while (nbOccursMelangee > 0) {
					rassemblee.add(elem);
					nbOccursMelangee--;
				}
			}

		}
		return rassemblee;
	}

	public static <T> boolean verifierRassemblement(List<T> list) {
		ListIterator<T> iter1 = list.listIterator();

		int size = list.size();
		int indexIter1 = 0;
		boolean continu = true;

		while (iter1.hasNext() && continu) {
			T elemIt1 = iter1.next();
			ListIterator<T> iter2 = list.listIterator();
			boolean differentRencontre = false;

			while (iter2.nextIndex() != iter1.nextIndex()) {

				T elemIt2 = iter2.next();

			}
			while (iter2.hasNext() && continu) {
				T elemIt2 = iter2.next();
				if (differentRencontre && elemIt1.equals(elemIt2)) {
					continu = false;
				}
				if (!elemIt1.equals(elemIt2)) {
					differentRencontre = true;
				}
			}

		}
		return continu;

	}

}
