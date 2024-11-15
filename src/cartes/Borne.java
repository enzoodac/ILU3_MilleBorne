package cartes;

public class Borne extends Carte implements Comparable<Borne> {
	private int km;

	public Borne(int km) {
		super();
		this.km = km;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return km + " KM";
	}

	public int getKm() {
		return this.km;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Borne) {
			Borne borne = (Borne) obj;
			return km == borne.km;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return getKm() + super.hashCode();
	}

	@Override
	public int compareTo(Borne borneToCompare) {
		return Integer.compare(km, borneToCompare.getKm());
	}

}
