package jeu;

import cartes.*;

public interface Cartes {
	public Botte prioritaire = new Botte(Type.FEU);
	public Attaque feuRouge = new Attaque(Type.FEU);
	public Parade feuVert = new Parade(Type.FEU);

}
