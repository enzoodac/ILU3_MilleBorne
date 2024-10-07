package cartes;

public class Borne extends Carte {
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

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Borne) {
			Borne borne = (Borne) obj;
			return km == borne.km;
		}
		return false;
	}

}
