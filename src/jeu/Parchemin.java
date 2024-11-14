package jeu;

public class Parchemin implements Comparable<Parchemin> {
    private int annee;
    private String titre;

    public Parchemin(int annee, String titre) {
        this.annee = annee;
        this.titre = titre;
    }

    public int getAnnee(){
        return this.annee;
    }

    public String getTitre(){
        return this.titre;
    }
    
    public int compareTo(Parchemin toCompare){
        int anneeComparison = Integer.compare(this.annee, toCompare.getAnnee());
        if(anneeComparison != 0){
            return anneeComparison;
        } else {
            return this.titre.compareTo(toCompare.getTitre());
        }
    }

//    public static void main(String[] args) {
//		Parchemin parchemin1 = new Parchemin(2000, "java");
//        Parchemin parchemin2 = new Parchemin(2001, "jaaa");
//        System.out.println(parchemin1.compareTo(parchemin2));
//	}
}