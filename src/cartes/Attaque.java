package cartes;

public class Attaque extends Bataille {

	public Attaque(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		return getType().getNomAttaque();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Attaque) {
			Attaque attaque = (Attaque) obj;
			return this.getType().equals(attaque.getType());
		}
		return false;
	}

}
