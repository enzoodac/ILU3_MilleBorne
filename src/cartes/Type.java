package cartes;

public enum Type {
	FEU("FeuRouge", "FeuVert", "VehiculePrioritaire"), ESSENCE("Panne d'Essence", "Essence", "Citerne d'Essence"),
	CREVAISON("Crevaison", "Roue de Secours", "Increvable"), ACCIDENT("Accident", "Réparation", "As du Volant");

	private String nomAttaque;
	private String nomParade;
	private String nomBotte;

	private Type(String nomAttaque, String nomParade, String nomBotte) {
		this.nomAttaque = nomAttaque;
		this.nomParade = nomParade;
		this.nomBotte = nomBotte;
	}

	public String getNomAttaque() {
		return nomAttaque;
	}

	public String getNomBotte() {
		return nomBotte;
	}

	public String getNomParade() {
		return nomParade;
	}

}
