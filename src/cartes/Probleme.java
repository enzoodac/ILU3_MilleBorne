package cartes;

import java.util.Objects;

public abstract class Probleme extends Carte implements Comparable<Probleme> {

	private Type type;

	protected Probleme(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	@Override
	public int hashCode() {
		return getType().hashCode() + super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Probleme other = (Probleme) obj;
		return type == other.type;
	}

	@Override
	public int compareTo(Probleme problemeToCompare) {
		return type.compareByFirstLetter(problemeToCompare.getType());
	}
}
