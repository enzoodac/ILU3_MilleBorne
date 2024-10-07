package cartes;

public class DebutLimite extends Limite {

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Debut limite";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DebutLimite) {

			return true;
		}
		return false;
	}

}
