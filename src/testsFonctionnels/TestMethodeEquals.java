package testsFonctionnels;

import cartes.*;

public class TestMethodeEquals {

	public static void main(String[] args) {
		Borne borne25_1 = new Borne(25);
		Borne borne25_2 = new Borne(25);
		Attaque feuRouge_1 = new Attaque(Type.FEU);
		Attaque feuRouge_2 = new Attaque(Type.FEU);
		Parade feuVert_1 = new Parade(Type.FEU);

		System.out.println(borne25_1.equals(borne25_2));
		System.out.println(feuRouge_1.equals(feuRouge_2));
		System.out.println(feuRouge_1.equals(feuVert_1));

	}

}
