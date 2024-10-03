package cartes;

public class JeuDeCartes {
	private Configuration[] typesDeCartes = new Configuration[19];

	public JeuDeCartes() {
		typesDeCartes[0] = new Configuration(10, new Borne(25));
		typesDeCartes[1] = new Configuration(10, new Borne(50));
		typesDeCartes[2] = new Configuration(10, new Borne(75));
		typesDeCartes[3] = new Configuration(12, new Borne(100));
		typesDeCartes[4] = new Configuration(4, new Borne(200));
		typesDeCartes[11] = new Configuration(4, new DebutLimite());
		typesDeCartes[6] = new Configuration(6, new FinLimite());
		typesDeCartes[5] = new Configuration(14, new Parade(Type.FEU));
		typesDeCartes[7] = new Configuration(6, new Parade(Type.ESSENCE));
		typesDeCartes[8] = new Configuration(6, new Parade(Type.CREVAISON));
		typesDeCartes[9] = new Configuration(6, new Parade(Type.ACCIDENT));
		typesDeCartes[10] = new Configuration(5, new Attaque(Type.FEU));
		typesDeCartes[12] = new Configuration(3, new Attaque(Type.ESSENCE));
		typesDeCartes[13] = new Configuration(3, new Attaque(Type.CREVAISON));
		typesDeCartes[14] = new Configuration(3, new Attaque(Type.ACCIDENT));
		typesDeCartes[15] = new Configuration(1, new Botte(Type.ESSENCE));
		typesDeCartes[16] = new Configuration(1, new Botte(Type.CREVAISON));
		typesDeCartes[17] = new Configuration(1, new Botte(Type.ACCIDENT));
		typesDeCartes[18] = new Configuration(1, new Botte(Type.FEU));
	}

	public String affichageJeuDeCartes() {
		StringBuilder jeu = new StringBuilder();
		for (int carte = 0; carte < 19; carte++) {
			jeu.append(
					typesDeCartes[carte].getnbExemplaires() + "  " + typesDeCartes[carte].getCarte().toString() + "\n");
		}
		return jeu.toString();
	}

	public Carte[] getToutesLesCartes() {
		int nbCartesConfig = 0;
		for (Configuration config : typesDeCartes) {
			nbCartesConfig += config.getnbExemplaires();
		}
		Carte[] cartes = new Carte[nbCartesConfig];
		int index = 0;
		for (Configuration config : typesDeCartes) {
			for (int i = 0; i < config.getnbExemplaires(); i++) {
				cartes[index] = config.getCarte();
				index++;

			}

		}
		return cartes;
	}

	public class Configuration {
		private int nbExemplaires;
		private Carte carte;

		public Configuration(int nbExemplaires, Carte carte) {
			super();
			this.nbExemplaires = nbExemplaires;
			this.carte = carte;
		}

		public Carte getCarte() {
			return carte;
		}

		public int getnbExemplaires() {
			return nbExemplaires;
		}

	}

}
