package cartes;

public class Parade extends Bataille {

	public Parade(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		return getType().getNomParade();

	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Parade) {
			Parade parade = (Parade) obj;
			return this.getType().equals(parade.getType());
		}
		return false;
	}

}
