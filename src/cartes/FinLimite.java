package cartes;

public class FinLimite extends Limite {

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Fin limite";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FinLimite) {

			return true;
		}
		return false;
	}
}
