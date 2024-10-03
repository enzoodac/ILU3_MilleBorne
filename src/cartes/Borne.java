package cartes;

public class Borne  extends Carte{
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

}
